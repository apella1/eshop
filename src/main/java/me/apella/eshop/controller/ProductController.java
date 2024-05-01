package me.apella.eshop.controller;

import me.apella.eshop.model.Product;
import me.apella.eshop.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>("Product created successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable UUID productId) {
        Product product = productService.getProductById(productId);

        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable UUID productId) {
        boolean deleted = productService.deleteProductById(productId);
        if (deleted) {
            return new ResponseEntity<>("Product deleted successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Product not found!", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<String> updateProductById(@PathVariable UUID productId, @RequestBody Product product) {
        boolean updated = productService.updateProductById(productId, product);
        if (updated) {
            return new ResponseEntity<>("Product updated successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Product not found!", HttpStatus.NOT_FOUND);
    }
}
