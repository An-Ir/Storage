package com.example.storage.business.storage;

import com.example.storage.business.feature.dto.FeatureType;
import com.example.storage.business.storage.dto.FilteredStorageRequest;
import com.example.storage.business.storage.dto.StorageImageInfo;
import com.example.storage.domain.image.Image;
import com.example.storage.domain.image.ImageService;
import com.example.storage.domain.storage.Storage;
import com.example.storage.domain.storage.StorageMapper;
import com.example.storage.domain.storage.StorageService;
import com.example.storage.domain.storagefeature.StorageFeatureService;
import com.example.storage.util.ImageConverter;
import jakarta.annotation.Resource;
import com.example.storage.business.storage.dto.FeatureInfo;
import com.example.storage.business.storage.dto.StorageDetailedInfo;
import com.example.storage.domain.county.County;
import com.example.storage.domain.county.CountyService;
import com.example.storage.domain.feature.Feature;
import com.example.storage.domain.feature.FeatureService;
import com.example.storage.domain.image.Image;
import com.example.storage.domain.image.ImageService;
import com.example.storage.domain.location.Location;
import com.example.storage.domain.location.LocationMapper;
import com.example.storage.domain.location.LocationService;
import com.example.storage.domain.storage.Storage;
import com.example.storage.domain.storage.StorageMapper;
import com.example.storage.domain.storage.StorageService;
import com.example.storage.domain.storagefeature.StorageFeature;
import com.example.storage.domain.storagefeature.StorageFeatureService;
import com.example.storage.domain.type.Type;
import com.example.storage.domain.type.TypeService;
import com.example.storage.domain.user.User;
import com.example.storage.domain.user.UserService;
import com.example.storage.util.ImageConverter;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoragesService {

    @Resource
    private StorageService storageService;

    @Resource
    private ImageService imageService;

    @Resource
    private StorageFeatureService storageFeatureService;

    @Resource
    private StorageMapper storageMapper;

    @Resource
    private UserService userService;

    @Resource
    private CountyService countyService;

    @Resource
    private TypeService typeService;

    @Resource
    private LocationMapper locationMapper;

    @Resource
    private LocationService locationService;

    @Resource
    private FeatureService featureService;

    public List<StorageImageInfo> getStorageInfos() {
        List<Storage> storages = storageService.getActiveStorages();
        List<StorageImageInfo> storageImageInfos = storageMapper.toStorageInfos(storages);
        addImageData(storageImageInfos);
        return storageImageInfos;
    }

    public List<StorageImageInfo> findFilteredStorages(FilteredStorageRequest request) {
        List<Integer> requiredFeatureIds = getRequiredFeatureIds(request.getFeatureTypes());
        List<Storage> storages = storageFeatureService.findFilteredStoragesBy(request.getCountyId(), requiredFeatureIds);
        List<StorageImageInfo> storageInfos = storageMapper.toStorageInfos(storages);
        addImageData(storageInfos);
        return storageInfos;
    }

    public void addNewStorage(Integer userId, StorageDetailedInfo storageDetailedInfo) {
        // TODO vaja teha eeltoo

        // TODO leia ulese userId abil User object.
        //  EntityService ->
        //  EntityRepository ->
        //  getReferenceById (selline meetod on JPA repositoris on olemas. ei pea uut tegima)
        //  = Entity object
        User user = userService.getUserBy(userId);

        // TODO leia ulese countyId abil County object.
        //  EntityService ->
        //  EntityRepository ->
        //  getReferenceById (selline metod on JPA repositoris on olemas. ei pea uut tegima)
        //  = Entity object
        County county = countyService.getCountyBy(storageDetailedInfo.getCountyId());


        // TODO leia ulese typeId abil Type object.
        //  EntityService ->
        //  EntityRepository ->
        //  getReferenceById (selline metod on JPA repositoris on olemas. ei pea uut tegima)
        //  = Entity object

        Type type = typeService.getTypeBy(storageDetailedInfo.getTypeId());


        // TODO on vaja teha uus sissekanne tabelisse location
        // TODO on vaja luua uus location object
        // TODO koige m6istlikum oleks kasutada LocationMapperit.
        //  sealt oleks vaja meetodit toLocation(), mis v6ttab sisse StorageDetailedInfo objecti ja tagastab Location objecti.
        //  Seda meetodit veel ei ole see tuleb luua.
        //  selliselt saad location objecti


        //  Ara said mappida lotidut ja latidute. Countyd ei saanud ega tohtinud ara mappida.
        //  See county object on eelnevalt olemas. Nuud peab selle county objecti lihtsalt panema location objecti kulge.


        Location location = locationMapper.toLocation(storageDetailedInfo);
        location.setCounty(county);


        //  Nuud on location object valmis. Peab lihtsalt selle ka andmebaasi ara salvestada.
        //  EntityService ->
        //  EntityRepository ->
        //  save() - selline metod on JPA repositoris on olemas. ei pea uut tegima.

        locationService.saveLocation(location);

        //  Nuud on location object valmis millel on kuljes ka Id (see rida on andmebaasis olemas)


        // TODO on vaja teha uus sissekanne tabelisse storage
        // TODO on vaja luua uus storage object
        // TODO koige m6istlikum oleks kasutada StorageMapperit.
        //  sealt oleks vaja meetodit toStorage(), mis v6ttab sisse StorageDetailedInfo objecti ja tagastab Storage objecti.
        //  Seda meetodit veel ei ole see tuleb luua.

        Storage storage = storageMapper.toStorage(storageDetailedInfo);

        //  selliselt saad storage objecti
        //  Ara said mappida area, price, description ja status.


        //  User, Type ja Locationit ei saa ega tohti ara mappida.
        //  Need User, Type ja Location objectid on eelnevalt olemas. Nuud peab need objectid lihtsalt panema storage objecti kulge.

        storage.setUser(user);
        storage.setType(type);
        storage.setLocation(location);

        //  Nuud on storage object valmis. Peab lihtsalt selle ka andmebaasi ara salvestada.
        //  EntityService ->
        //  EntityRepository ->
        //  save() - selline metod on JPA repositoris on olemas. ei pea uut tegima.
        //  Nuud on storage object valmis millel on kuljes ka Id (see rida on andmebaasis olemas)

        storageService.saveStorage(storage);

//
        String imageData = storageDetailedInfo.getImageData();
        byte[] bytes = ImageConverter.stringToByteArray(imageData);

        Image image = new Image();
        image.setStorage(storage);
        image.setData(bytes);

        imageService.saveImage(image);

        // TODO on vaja teha uued sissekanded tabelisse storage_feature
        // TODO on vaja luua uus tuhi list StorageFeature objectidest (new ArrayList) ja panna muutuja nimeks storageFeatures



        List<StorageFeature> storageFeatures = new ArrayList<>();
        // TODO on vaja v6tta StorageDetailedInfo objecti seest List<FeatureInfo> featureInfos massiiv

        List<FeatureInfo> featureInfos = storageDetailedInfo.getFeatureInfos();

        //  nuud oleks vaja for loopida seda featureInfos massiivi

        for (FeatureInfo featureInfo : featureInfos) {
            //  Igal tsuklil tuleb vaadata uhte featureInfo objecti
            //  Kui featureInfo objecti vali isAvailable on true

            if (featureInfo.getIsAvailable()) {
                //  siis tuleb leida valja featureId abil ulesse feature object (Entity)
                //  EntityService ->
                //        //  EntityRepository ->
                //        //  getReferenceById (selline metod on JPA repositoris on olemas. ei pea uut tegima)
                //        //  = Entity object
                Feature feature = featureService.getFeatureBy(featureInfo.getFeatureId());
                //  Nuud on sul olemas feature object (Entity)
                //  Nuud on vaja luua uus storageFeature object (new StorageInfo()).
                StorageFeature storageFeature = new StorageFeature();

                //  Nuud peab selle storageFeature objecti kulge panema storage ja feature objecti. (storage object on sul varasemalt olemas)


                storageFeature.setStorage(storage);
                storageFeature.setFeature(feature);

                //  Nuud on storageFeature object valmis. Peab lihtsalt selle lisama storageFeatures listi
                storageFeatures.add(storageFeature);

            }

        }

        storageFeatureService.saveAll(storageFeatures);








        //  parast for tsuklit on sul olemas taidetud storageFeatures list
        //  Peab lihtsalt selle ka andmebaasi ara salvestada.

        //  EntityService ->
        //  EntityRepository ->
        //  saveAll() - selline metod on JPA repositoris on olemas. ei pea uut tegima. See meetod v6tab sisse Entityd listi
        //  Finito

    }
}

    private void addImageData(List<StorageImageInfo> storageImageInfos) {
        for (StorageImageInfo storageImageInfo : storageImageInfos) {
            Image image = imageService.getImageBy(storageImageInfo.getStorageId());
            String imageAsString = ImageConverter.byteArrayToString(image.getData());
            storageImageInfo.setImageData(imageAsString);
        }
    }


    private static List<Integer> getRequiredFeatureIds(List<FeatureType> featureTypes) {
        List<Integer> requiredFeatureIds = new ArrayList<>();
        for (FeatureType featureType : featureTypes) {
            if (featureType.getIsAvailable()) {
                requiredFeatureIds.add(featureType.getFeatureId());
            }
        }
        return requiredFeatureIds;
    }
}