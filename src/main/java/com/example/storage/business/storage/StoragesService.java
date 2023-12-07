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