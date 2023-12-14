package com.example.storage.domain.storagefeature;

import com.example.storage.domain.storage.Storage;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageFeatureService {

    @Resource
    private StorageFeatureRepository storageFeatureRepository;

    public List<Storage> findFilteredStoragesBy(Integer countyId, List<Integer> requiredFeatureIds) {
        return storageFeatureRepository.findStoragesByFeatureIds(countyId, requiredFeatureIds, requiredFeatureIds.size());
    }


    public void saveAll(List<StorageFeature> storageStorageFeatures) {
        storageFeatureRepository.saveAll(storageStorageFeatures);
    }

    public List<StorageFeature> getStorageFeatures(Integer storageId) {
        return storageFeatureRepository.findStorageFeaturesBy(storageId);
    }
    public List<Integer> findStorageFeatureIdsBy(Integer storageId) {
        return storageFeatureRepository.findStorageFeaturesIdsBy(storageId);
    }
}
