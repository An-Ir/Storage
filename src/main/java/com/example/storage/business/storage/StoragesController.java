package com.example.storage.business.storage;

import com.example.storage.business.storage.dto.StorageInfo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storage")
public class StoragesController {


    @PostMapping
    @Operation(summary = "Uue lao lisamine")
    public void addNewStorage(@RequestBody StorageInfo storageInfo) {

    }

}
