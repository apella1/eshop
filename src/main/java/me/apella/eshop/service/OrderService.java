package me.apella.eshop.service;

import me.apella.eshop.model.Order;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    List<Order> findAll();

    Order getOrderById(UUID orderId);

    void createOrder(Order order);

    boolean updateOrderById(UUID orderId, Order updatedOrder);

    boolean deleteOrderById(UUID orderId);
}
