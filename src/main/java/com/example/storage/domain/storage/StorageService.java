package com.example.storage.domain.storage;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StorageService {

    @Resource
    private StorageRepository storageRepository;
    public void saveStorage(Storage storage) {
        storageRepository.save(storage);
    }
}
