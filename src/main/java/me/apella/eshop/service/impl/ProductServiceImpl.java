package me.apella.eshop.service.impl;

import me.apella.eshop.model.Product;
import me.apella.eshop.repository.ProductRepository;
import me.apella.eshop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(UUID orderId) {
        return productRepository.findById(orderId).orElse(null);
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public boolean updateProductById(UUID productId, Product updatedProduct) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setCategory(updatedProduct.getCategory());
            product.setDescription(updatedProduct.getDescription());
            product.setName(updatedProduct.getName());
            product.setStock(updatedProduct.getStock());
            productRepository.save(product);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProductById(UUID productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            productRepository.deleteById(productId);
            return true;
        }
        return false;
    }
}
