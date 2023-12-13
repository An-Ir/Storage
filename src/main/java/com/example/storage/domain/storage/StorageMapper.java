package com.example.storage.domain.storage;

import com.example.storage.business.storage.dto.StorageDetailedInfo;
import com.example.storage.business.storage.dto.StorageImageInfo;
import com.example.storage.business.storage.dto.UserStorageInfo;
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


    @Mapping(source = "id", target = "storageId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "name", target = "storageName")
    @Mapping(source = "price", target = "storagePrice")
    @Mapping(source = "description", target = "description")
    UserStorageInfo toUserStorageInfo(Storage storage);

    List<UserStorageInfo> toUserStorageInfos(List<Storage> storages);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "storageName", target = "name")
    @Mapping(source = "squareMeters", target = "area")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    Storage partialUpdate(@MappingTarget Storage storage, StorageDetailedInfo storageDetailedInfo);


}