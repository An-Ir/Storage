package com.example.storage.business.storage.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class StorageDetailedInfo {
    private Integer countyId;
    private Integer typeId;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private Integer squareMeters;
    private String storageName;
    private Integer price;
    private String description;
    private String imageData;
    private List<FeatureInfo> featureInfos;
}
