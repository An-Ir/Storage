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
public class UserStorageInfo implements Serializable {
    private Integer storageId;
    private Integer userId;
    @NotNull
    @Size(max = 50)
    private String storageName;
    @NotNull
    private Integer storagePrice;
    @NotNull
    @Size(max = 600)
    private String description;
    private String imageData;
}