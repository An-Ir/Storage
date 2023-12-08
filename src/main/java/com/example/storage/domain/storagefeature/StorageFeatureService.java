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
}

