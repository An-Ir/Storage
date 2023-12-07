package com.example.storage.business.feature;

import com.example.storage.business.feature.dto.FeatureType;
import com.example.storage.domain.feature.Feature;
import com.example.storage.domain.feature.FeatureMapper;
import com.example.storage.domain.feature.FeatureService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeaturesService {

    @Resource
    private FeatureService featureService;

    @Resource
    private FeatureMapper featureMapper;

    public List<FeatureType> getAllFeatureTypes() {
        List<Feature> allFeatures = featureService.getAllFeatures();
        return featureMapper.toFeatureTypes(allFeatures);
    }
}
