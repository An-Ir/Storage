package com.example.storage.business.storage;
import com.example.storage.business.storage.dto.StorageImageInfo;

import com.example.storage.business.storage.dto.StorageInfo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;

import java.util.List;

@RestController
public class StoragesController {

    @Resource
    private StoragesService storagesService;

    @PostMapping("/storage")
    @Operation(summary = "Uue lao lisamine")
    public void addNewStorage(@RequestBody StorageInfo storageInfo) {
    }

    @GetMapping("/locations")
    @Operation(summary = "Tagastab asukohtade pildid koos nimedega.",
    description = "Kui filtreid pole rakendatud, tagastatakse kõik asukohad.")
    public List<StorageImageInfo> getStorageNameAndImage() {
        return storagesService.getStorageInfos();
    }

}
