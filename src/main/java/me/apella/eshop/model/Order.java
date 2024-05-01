package me.apella.eshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotEmpty
    private String userId;
    @NotEmpty
    private String orderDate;
    private String status;
    @Positive
    private String totalPrice;
    @OneToMany
    private List<Product> products;

    public Order() {
    }

    public Order(UUID id, String userId, String orderDate, String status, String totalPrice, List<Product> products) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.status = status;
        this.totalPrice = totalPrice;
        this.products = products;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotEmpty String getUserId() {
        return userId;
    }

    public void setUserId(@NotEmpty String userId) {
        this.userId = userId;
    }

    public @NotEmpty String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(@NotEmpty String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public @Positive String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(@Positive String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
