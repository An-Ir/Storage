package com.example.storage.domain.feature;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureService {

    @Resource
    private FeatureRepository featureRepository;

    public List<Feature> getAllFeatures() {
        return featureRepository.findAll();
    }
    public Feature getFeatureBy(Integer featureId) {

        return featureRepository.getReferenceById(featureId);
    }

}
