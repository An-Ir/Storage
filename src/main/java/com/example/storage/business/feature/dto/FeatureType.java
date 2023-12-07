package com.example.storage.business.feature.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.example.storage.domain.feature.Feature}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeatureType implements Serializable {
    private Integer featureId;
    @NotNull
    @Size(max = 255)
    private String featureName;
    private Boolean isAvailable;

}