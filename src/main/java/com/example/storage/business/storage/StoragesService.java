package com.example.storage.business.storage;

import com.example.storage.business.storage.dto.StorageImageInfo;
import com.example.storage.domain.image.Image;
import com.example.storage.domain.image.ImageService;
import com.example.storage.domain.storage.Storage;
import com.example.storage.domain.storage.StorageMapper;
import com.example.storage.domain.storage.StorageService;
import com.example.storage.util.ImageConverter;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoragesService {

    @Resource
    private StorageService storageService;

    @Resource
    private ImageService imageService;

    @Resource
    private StorageMapper storageMapper;

    public List<StorageImageInfo> getStorageInfos() {
        List<Storage> storages = storageService.getActiveStorages();
        List<StorageImageInfo> storageImageInfos = storageMapper.toStorageInfos(storages);
        addImageData(storageImageInfos);
        return storageImageInfos;
    }

    private void addImageData(List<StorageImageInfo> storageImageInfos) {
        for (StorageImageInfo storageImageInfo : storageImageInfos) {
            Image image = imageService.getImageBy(storageImageInfo.getStorageId());
            String imageAsString = ImageConverter.byteArrayToString(image.getData());
            storageImageInfo.setImageData(imageAsString);
        }
    }
}
