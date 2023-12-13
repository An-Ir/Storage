package com.example.storage.business.order.dto;

import com.example.storage.domain.order.Order;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Order}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfo implements Serializable {
    private Integer customerId;
    private Integer storageId;
    private String storageName;
    private Integer storagePrice;
    private String storageDescription;
    private String imageData;
    @NotNull
    private Integer orderId;
    private LocalDate startDate;
    private LocalDate endDate;
}