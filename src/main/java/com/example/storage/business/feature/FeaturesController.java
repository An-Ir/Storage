package com.example.storage.business.feature;

import com.example.storage.business.feature.dto.FeatureType;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeaturesController {

    @Resource
    private FeaturesService featuresService;

    @GetMapping("/storage/features")
    @Operation(summary="tagastab kõik feature tüübid")
    public List<FeatureType> getAllFeatureTypes() {
        return featuresService.getAllFeatureTypes();
    }
}
