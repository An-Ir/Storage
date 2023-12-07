package com.example.storage.domain.type;
import com.example.storage.business.type.dto.TypeInfo;
import org.mapstruct.*;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TypeMapper {
    @Mapping(source = "id", target = "typeId")
    @Mapping(source = "name", target = "typeName")
    TypeInfo toTypeInfo(Type type);

    List<TypeInfo> toTypeInfos(List<Type> types);



    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    com.example.storage.domain.type.Type partialUpdate(TypeInfo typeDto, @MappingTarget com.example.storage.domain.type.Type type);
}