package com.example.storage.domain.storagefeature;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StorageFeatureMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "storage.id", target = "storageId")
    @Mapping(source = "feature.id", target = "featureId")
    StorageFeatureDto toStorageFeatureDto(StorageFeature storageFeature);

   List <StorageFeatureDto> toStorageFeatureDtos(List<StorageFeature> storageFeatures);

}