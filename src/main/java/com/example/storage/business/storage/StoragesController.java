package com.example.storage.business.storage;
import com.example.storage.business.storage.dto.StorageImageInfo;

import com.example.storage.business.storage.dto.StorageInfo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.annotation.Resource;

@RestController
@RequestMapping("/storage")
public class StoragesController {

    @Resource
    private StoragesService storagesService;

    @PostMapping
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
