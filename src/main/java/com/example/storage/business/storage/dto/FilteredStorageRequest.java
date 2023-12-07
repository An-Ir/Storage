package com.example.storage.business.storage.dto;

import com.example.storage.business.feature.dto.FeatureType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilteredStorageRequest {
    private Integer countyId;
    private List<FeatureType> featureTypes;
}
