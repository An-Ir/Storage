package com.example.storage.business.storage;

import com.example.storage.business.storage.dto.StorageImageInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoragesController {

    @Resource
    private StoragesService storagesService;

    @GetMapping("/locations")
    @Operation(summary = "Tagastab asukohtade pildid koos nimedega.",
    description = "Kui filtreid pole rakendatud, tagastatakse kõik asukohad.")
    public List<StorageImageInfo> getStorageNameAndImage() {
        return storagesService.getStorageInfos();
    }
}
