package com.example.storage.business.storage.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class StorageDetailedInfo {
    private String storageName;
    private Integer locationId;
    private Integer countyId;
    private String countyName;
    private Integer typeId;
    private String typeName;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private Integer squareMeters;
    private String storageName;
    private Integer price;
    private String description;
    private String imageData;
    private List<FeatureInfo> featureInfos;
}
