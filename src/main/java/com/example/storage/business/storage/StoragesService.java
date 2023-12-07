package com.example.storage.business.storage;

import com.example.storage.business.feature.dto.FeatureType;
import com.example.storage.business.storage.dto.FilteredStorageRequest;
import com.example.storage.business.storage.dto.StorageImageInfo;
import com.example.storage.domain.image.Image;
import com.example.storage.domain.image.ImageService;
import com.example.storage.domain.storage.Storage;
import com.example.storage.domain.storage.StorageMapper;
import com.example.storage.domain.storage.StorageService;
import com.example.storage.domain.storagefeature.StorageFeature;
import com.example.storage.domain.storagefeature.StorageFeatureDto;
import com.example.storage.domain.storagefeature.StorageFeatureMapper;
import com.example.storage.domain.storagefeature.StorageFeatureService;
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
    private StorageFeatureMapper storageFeatureMapper;

    public List<StorageImageInfo> getStorageInfos() {
        List<Storage> storages = storageService.getActiveStorages();
        List<StorageImageInfo> storageImageInfos = storageMapper.toStorageInfos(storages);
        addImageData(storageImageInfos);
        return storageImageInfos;
    }

    private void addImageData(List<StorageImageInfo> storageImageInfos) {
        for (StorageImageInfo storageImageInfo : storageImageInfos) {
            Image image = imageService.getImageBy(storageImageInfo.getStorageId());
            String imageAsString = ImageConverter.byteArrayToString(image.getData());
            storageImageInfo.setImageData(imageAsString);
        }
    }

    public List<StorageFeatureDto> findFilteredStorages(FilteredStorageRequest request) {
//        List<Storage> filteredStorages = storageService.getStorageInfoBy(countyId);
//        List<StorageImageInfo> filteredstorageInfos = storageMapper.toStorageInfos(filteredStorages);
//        addImageData(filteredstorageInfos);
        List<FeatureType> featureTypes = request.getFeatureTypes();
        List<Integer> integerList = new ArrayList<>();
        for (FeatureType featureType : featureTypes) {
            if (featureType.getIsAvailable()) {
                Integer featureId = featureType.getFeatureId();
                integerList.add(featureId); // Add featureId to the integerList
            }
        }

        Integer[] requiredFeatureIds = integerList.toArray(new Integer[0]);


        List<StorageFeature> filteredStorages = storageFeatureService.findFilteredStoragesBy(request.getCountyId(), requiredFeatureIds);
        return storageFeatureMapper.toStorageFeatureDtos(filteredStorages);

    }
}

