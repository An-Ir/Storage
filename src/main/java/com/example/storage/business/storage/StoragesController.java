package com.example.storage.business.storage;

import com.example.storage.business.storage.dto.FilteredStorageRequest;
import com.example.storage.business.storage.dto.StorageImageInfo;
import com.example.storage.business.storage.dto.StorageDetailedInfo;
import com.example.storage.business.storage.dto.StorageImageInfo;
import com.example.storage.business.storage.dto.UserStorageInfo;
import com.example.storage.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class StoragesController {

    @Resource
    private StoragesService storagesService;

    @PostMapping("/storage")
    @Operation(summary = "Uue pinna lisamine")
    public void addNewStorage(@RequestParam Integer userId, @RequestBody StorageDetailedInfo storageDetailedInfo) {
        storagesService.addNewStorage(userId, storageDetailedInfo);

    }

    @GetMapping("/storage")
    @Operation(summary = "Ühe lao andmete tagastamine")
    public StorageDetailedInfo getStorageDetailedInfo(@RequestParam Integer storageId) {
        return storagesService.getStorageDetailedInfo(storageId);
    }


    @GetMapping("/locations")
    @Operation(summary = "Tagastab asukohtade pildid koos nimedega.",
            description = "Kui filtreid pole rakendatud, tagastatakse kõik asukohad.")
    public List<StorageImageInfo> getStorageNameAndImage() {
        return storagesService.getStorageInfos();
    }

    @PostMapping("/locations/filtered")
    @Operation(summary = "Tagastab vastavalt valitud maakonnale ja teenustele asukohtade pildid koos nimedega.",
            description = "Kui filtritele vastavaid asukohti ei leita, visatakse viga errorcode'iga 222 ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Valikutele vastavat rendipinda ei ole", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<StorageImageInfo> findFilteredStorages(@RequestBody FilteredStorageRequest request) {
        return storagesService.findFilteredStorages(request);
    }

    @GetMapping("/mystorages")
    @Operation(summary = "tagastab vastavalt userId-le kasutaja hallatavad rendipinnad koos piltidega")
    public List<UserStorageInfo> findUserStorages(@RequestParam Integer userId) {
        return storagesService.findUserStorages(userId);
    }

    @DeleteMapping("/storage")
    @Operation(summary = "kustutab asukoha storageId järgi")
    public void deleteStorage(@RequestParam Integer storageId) {
        storagesService.deleteStorage(storageId);
    }

    @PutMapping("/mystorages")
    @Operation(summary = "Uuendab storageId abil ara storage Info")
    public void updateStorageInfo(@RequestParam Integer storageId, @RequestBody StorageDetailedInfo storageDetailedInfo) {
        storagesService.updateStorageInfo(storageId, storageDetailedInfo);
    }
}