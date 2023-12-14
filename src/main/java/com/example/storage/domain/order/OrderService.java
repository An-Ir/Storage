package com.example.storage.domain.order;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Resource
    private OrderRepository orderRepository;

    public List<Order> getCustomerOrders(Integer customerUserId) {
        return orderRepository.findByCustomerUserId(customerUserId);
    }

    public Order findOrderById(Integer orderId) {
        return orderRepository.getReferenceById(orderId);
    }
}
