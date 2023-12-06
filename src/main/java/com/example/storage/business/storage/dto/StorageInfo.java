package com.example.storage.business.storage.dto;

import com.example.storage.domain.type.Type;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class StorageInfo {
    private Integer countyId;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private Integer area;
    private Integer typeId;
    private List<Integer> featureIds;
    private Integer price;
    private String status;
    private String description;
    private Integer imageId;
}
