package com.example.storage.domain.order;

import com.example.storage.business.Status;
import com.example.storage.business.order.dto.OrderInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    @Mapping(source = "customerUser.id", target = "customerId")
    @Mapping(source = "storage.id", target = "storageId")
    @Mapping(source = "storage.name", target = "storageName")
    @Mapping(source = "storage.price", target = "storagePrice")
    @Mapping(source = "storage.description", target = "storageDescription")
    @Mapping(source = "id", target = "orderId")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "status", target = "status", qualifiedByName = "getFullStatus")
    OrderInfo toOrderInfo(Order order);


    @Named("getFullStatus")
    static String getFullStatus(String shortStatus) {
        return switch (shortStatus) {
            case Status.BOOKED -> "Broneeritud";
            case Status.CANCELLED -> "Tühistatud";
            default -> "lõppenud";
        };
    }

    List<OrderInfo> toOrderInfos(List<Order> orders);

}