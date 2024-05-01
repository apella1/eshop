package me.apella.eshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank(message = "Name is required!")
    private String name;
    @NotBlank(message = "Email is required!")
    @Email(message = "${validationValue} is not a valid email")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "Password is required!")
    @NotNull
    @Size(min = 8, message = "Password should contain at least ${min} characters.")
    @Size(max = 100, message = "Password should contain at most ${max} characters.")
    private String password;
    private String shippingAddress;

    public User() {
    }

    public User(UUID id, String name, String email, String password, String shippingAddress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.shippingAddress = shippingAddress;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
