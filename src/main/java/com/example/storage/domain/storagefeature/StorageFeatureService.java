package com.example.storage.domain.storagefeature;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageFeatureService {

    @Resource
    private StorageFeatureRepository storageFeatureRepository;

    public List<StorageFeature> findFilteredStoragesBy(Integer countyId, Integer[] requiredFeatureIds) {

        Integer[] featureIds = new Integer[]{1, 2};
        Long numFeatures = 2L;
        return storageFeatureRepository.findStoragesByFeatureIds(featureIds, numFeatures);
    }
}
