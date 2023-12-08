package com.example.storage.domain.location;

import com.example.storage.business.storage.dto.StorageDetailedInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {

    @Mapping(source = "latitude", target = "latitude")
    @Mapping(source = "longitude", target = "longitude")
    Location toLocation(StorageDetailedInfo storageDetailedInfo);

}