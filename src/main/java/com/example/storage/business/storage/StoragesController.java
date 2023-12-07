package com.example.storage.business.storage;

import com.example.storage.business.storage.dto.FilteredStorageRequest;
import com.example.storage.business.storage.dto.StorageImageInfo;

import com.example.storage.business.storage.dto.StorageInfo;
import com.example.storage.domain.storagefeature.StorageFeatureDto;
import com.example.storage.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @PostMapping("/locations/filtered")
    @Operation(summary = "Tagastab vastavalt valitud maakonnale ja teenustele asukohtade pildid koos nimedega.",
            description = "Kui filtritele vastavaid asukohti ei leita, visatakse viga errorcode'iga 222 ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Valikutele vastavat rendipinda ei ole", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<StorageFeatureDto> findFilteredStorages(@RequestBody FilteredStorageRequest request) {
        return storagesService.findFilteredStorages(request);
    }

}
