package com.example.storage.domain.storage;

import com.example.storage.business.Status;
import com.example.storage.domain.feature.FeatureRepository;
import com.example.storage.domain.storagefeature.StorageFeature;
import com.example.storage.domain.storagefeature.StorageFeatureRepository;
import com.example.storage.infrastructure.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageService {

    @Resource
    private StorageRepository storageRepository;

    public List<Storage> getActiveStorages() {
        return storageRepository.findByStatus(Status.ACTIVE);
    }

    public void saveStorage(Storage storage) {
        storageRepository.save(storage);
    }
}
