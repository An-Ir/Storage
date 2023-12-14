package com.example.storage.domain.feature;

import com.example.storage.business.feature.dto.FeatureType;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FeatureMapper {
    @Mapping(source = "id", target = "featureId")
    @Mapping(source = "name", target = "featureName")
    @Mapping(constant = "false", target = "isAvailable")
    FeatureType toFeatureType(Feature feature);

    List<FeatureType> toFeatureTypes(List<Feature> features);



}