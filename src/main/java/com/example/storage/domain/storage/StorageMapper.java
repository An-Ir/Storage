package com.example.storage.domain.storage;

import com.example.storage.business.storage.dto.StorageDetailedInfo;
import com.example.storage.business.storage.dto.StorageImageInfo;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StorageMapper {

    @Mapping(source = "name", target = "storageName")
    @Mapping(source = "id", target = "storageId")
    @Mapping(source = "price", target = "storagePrice")
    StorageImageInfo toStorageInfo(Storage storage);

    List<StorageImageInfo> toStorageInfos(List<Storage> storages);


    @Mapping(source = "squareMeters", target = "area")
    @Mapping(source = "description", target = "description")
    @Mapping(constant = "A", target = "status")
    @Mapping(source = "price", target = "price")
    Storage toStorage(StorageDetailedInfo storageDetailedInfo);


    @Mapping(source = "location.id", target = "locationId")
    @Mapping(source = "location.county.id", target = "countyId")
    @Mapping(source = "location.county.name", target = "countyName")
    @Mapping(source = "location.latitude", target = "latitude")
    @Mapping(source = "location.longitude", target = "longitude")
    @Mapping(source = "type.id", target = "typeId")
    @Mapping(source = "type.name", target = "typeName")
    @Mapping(source = "name", target = "storageName")
    @Mapping(source = "area", target = "squareMeters")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    StorageDetailedInfo toStorageDetailedInfo(Storage storage);


}