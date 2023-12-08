package com.example.storage.domain.feature;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class FeatureService {

    @Resource
    private FeatureRepository featureRepository;

    public Feature getFeatureBy(Integer featureId) {

        return featureRepository.getReferenceById(featureId);
    }
}
