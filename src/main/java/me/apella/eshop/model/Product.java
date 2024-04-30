package me.apella.eshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    private String category;
    @NotEmpty
    private String imageUrl;
    @Positive
    private Integer stock;

    public Product(UUID id, String name, String description, String category, Integer stock, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.stock = stock;
        this.imageUrl = imageUrl;
    }

    public Product() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotEmpty String getName() {
        return name;
    }

    public void setName(@NotEmpty String name) {
        this.name = name;
    }

    public @NotEmpty String getDescription() {
        return description;
    }

    public void setDescription(@NotEmpty String description) {
        this.description = description;
    }

    public @NotEmpty String getCategory() {
        return category;
    }

    public void setCategory(@NotEmpty String category) {
        this.category = category;
    }

    public @NotEmpty String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(@NotEmpty String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public @Positive Integer getStock() {
        return stock;
    }

    public void setStock(@Positive Integer stock) {
        this.stock = stock;
    }
}

