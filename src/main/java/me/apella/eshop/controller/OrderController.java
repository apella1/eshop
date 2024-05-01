package me.apella.eshop.controller;

import me.apella.eshop.model.Order;
import me.apella.eshop.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> orders = orderService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return new ResponseEntity<>("Order created successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable UUID orderId) {
        Order order = orderService.getOrderById(orderId);

        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrderById(@PathVariable UUID orderId) {
        boolean deleted = orderService.deleteOrderById(orderId);
        if (deleted) {
            return new ResponseEntity<>("Order deleted successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Order not found!", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<String> updateOrderById(@PathVariable UUID orderId, @RequestBody Order order) {
        boolean updated = orderService.updateOrderById(orderId, order);
        if (updated) {
            return new ResponseEntity<>("Order updated successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Order not found!", HttpStatus.NOT_FOUND);
    }
}
