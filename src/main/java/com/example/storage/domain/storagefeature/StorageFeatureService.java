package com.example.storage.domain.storagefeature;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StorageFeatureService {
    @Resource
    private StorageFeatureRepository storageFeatureRepository;


}
