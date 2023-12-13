package com.example.storage.domain.user;

import com.example.storage.business.login.dto.LoginResponse;
import com.example.storage.business.profile.dto.UserInfo;
import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);

    @Mapping(source = "roleId", target = "role.id")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    User toEntity(UserInfo userInfo);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    User partialUpdate(@MappingTarget User user, UserInfo userInfo);
}