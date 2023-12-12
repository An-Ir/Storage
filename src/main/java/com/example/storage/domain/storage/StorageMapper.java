package com.example.storage.domain.storage;

import com.example.storage.business.storage.dto.StorageDetailedInfo;
import com.example.storage.business.storage.dto.StorageImageInfo;
import com.example.storage.business.storage.dto.UserStorageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

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


}