package com.example.storage.business.order;

import com.example.storage.business.Status;
import com.example.storage.business.order.dto.OrderInfo;
import com.example.storage.domain.image.Image;
import com.example.storage.domain.image.ImageService;
import com.example.storage.domain.order.Order;
import com.example.storage.domain.order.OrderMapper;
import com.example.storage.domain.order.OrderRepository;
import com.example.storage.domain.order.OrderService;
import com.example.storage.util.ImageConverter;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Resource
    private OrderService orderService;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private ImageService imageService;
    private final OrderRepository orderRepository;

    public OrdersService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderInfo> findCustomerOrders(Integer customerUserId) {
        List<Order> orders = orderService.getCustomerOrders(customerUserId);
        List<OrderInfo> orderInfos = orderMapper.toOrderInfos(orders);
        addImageData(orderInfos);
        return orderInfos;

    }

    private void addImageData(List<OrderInfo> orderInfos) {
        for (OrderInfo orderInfo : orderInfos) {
            Image image = imageService.getImageBy(orderInfo.getStorageId());
            String imageAsString = ImageConverter.byteArrayToString(image.getData());
            orderInfo.setImageData(imageAsString);
        }
    }

    public void cancelOrder(Integer orderId) {
        Order order = orderService.findOrderById(orderId);
        order.setStatus(Status.CANCELLED);
        orderRepository.save(order);
    }
}
