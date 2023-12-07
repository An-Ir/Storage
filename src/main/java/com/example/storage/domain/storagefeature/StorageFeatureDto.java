package com.example.storage.domain.storagefeature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link StorageFeature}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorageFeatureDto implements Serializable {
    private Integer id;
    private Integer storageId;
    private Integer featureId;
}