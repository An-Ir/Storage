package com.example.storage.domain.storage;

import com.example.storage.business.Status;
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

    public List<Storage> getStorageInfoBy(Integer countyId) {
        List<Storage> filteredStorages = storageRepository.findByLocationCountyIdAndStatus(countyId, Status.ACTIVE);
        ValidationService.validateStoragesFound(filteredStorages);
        return filteredStorages;
    }
}
