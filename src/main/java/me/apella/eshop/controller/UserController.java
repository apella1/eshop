package me.apella.eshop.controller;

import me.apella.eshop.model.User;
import me.apella.eshop.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody User customer) {
        userService.createUser(customer);
        return new ResponseEntity<>("User created successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable UUID userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable UUID userId) {
        boolean deleted = userService.deleteUserById(userId);
        if (deleted) {
            return new ResponseEntity<>("Customer deleted successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Customer not found!", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUserById(@PathVariable UUID userId, @RequestBody User updatedUser) {
        boolean updated = userService.updateUserById(userId, updatedUser);
        if (updated) {
            return new ResponseEntity<>("User updated successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
    }

}
