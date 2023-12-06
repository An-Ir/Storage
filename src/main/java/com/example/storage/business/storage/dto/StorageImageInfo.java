package com.example.storage.business.storage.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.example.storage.domain.storage.Storage}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorageImageInfo implements Serializable {
    private Integer storageId;
    @NotNull
    @Size(max = 50)
    private String storageName;
    private Integer storagePrice;
    private String imageData;

}