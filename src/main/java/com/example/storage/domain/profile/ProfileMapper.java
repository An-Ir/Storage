package com.example.storage.domain.profile;

import com.example.storage.business.profile.dto.UserInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    Profile toEntity(UserInfo userInfo);

    @Mapping(source = "user.role.id", target = "roleId")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "user.password", target = "password")
    UserInfo toUserInfo(Profile profile);
}