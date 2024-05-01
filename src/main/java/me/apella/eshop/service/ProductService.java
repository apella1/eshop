package me.apella.eshop.service;

import me.apella.eshop.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> findAll();

    Product getProductById(UUID orderId);

    void createProduct(Product product);

    boolean updateProductById(UUID productId, Product updatedProduct);

    boolean deleteProductById(UUID productId);
}
