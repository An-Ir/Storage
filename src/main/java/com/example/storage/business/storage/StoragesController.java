package com.example.storage.business.storage;

import com.example.storage.business.storage.dto.StorageDetailedInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/storage")
public class StoragesController {
    @Resource
    private StoragesService storagesService;

    @PostMapping
    @Operation(summary = "Uue pinna lisamine")
    public void addNewStorage(@RequestParam Integer userId, @RequestBody StorageDetailedInfo storageDetailedInfo) {
        storagesService.addNewStorage(userId, storageDetailedInfo);

    }

}
