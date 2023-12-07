package com.example.storage.business.type.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.storage.domain.type.Type}
 */
@Value
public class TypeInfo implements Serializable {
    Integer typeId;
    @NotNull
    @Size(max = 255)
    String typeName;
}