package com.example.storage.domain.storage;

import com.example.storage.business.Status;
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

    public Storage getStorageBy(Integer storageId) {
        return storageRepository.getReferenceById(storageId);
    }
    public void saveStorage(Storage storage) {
        storageRepository.save(storage);
    }

    public List<Storage> getUserStorageInfos(Integer userId) {
        return storageRepository.findByUserIdAndStatus(userId, Status.ACTIVE);
    }


    public Storage getStorageBy(Integer storageId) {
        return storageRepository.getReferenceById(storageId);
    }
}
