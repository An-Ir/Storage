package com.example.storage.domain.county;

import com.example.storage.business.county.dto.CountyInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountyMapper {

    @Mapping(source = "id", target = "countyId")
    @Mapping(source = "name", target = "countyName")
    CountyInfo toCountyInfo(County county);

    List<CountyInfo> toCountyInfos(List<County> counties);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    County partialUpdate(CountyInfo countyInfo, @MappingTarget County county);
}