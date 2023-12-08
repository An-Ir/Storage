package com.example.storage.domain.storagefeature;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageFeatureService {
    @Resource
    private StorageFeatureRepository storageFeatureRepository;


    public void saveAll(List<StorageFeature> storageFeatures) {
        storageFeatureRepository.saveAll(storageFeatures);
    }
}
