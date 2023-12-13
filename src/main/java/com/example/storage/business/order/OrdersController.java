package com.example.storage.business.order;

import com.example.storage.business.order.dto.OrderInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {

    @Resource
    private OrdersService ordersService;

    @GetMapping("/myorders")
    @Operation(summary = "tagastab laopinnad vastavalt order tabeli customerUserId-le")
    public List<OrderInfo> findCustomerOrders(Integer customerUserId) {
        return ordersService.findCustomerOrders(customerUserId);

    }
}
