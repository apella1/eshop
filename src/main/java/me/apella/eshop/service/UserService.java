package me.apella.eshop.service;

import me.apella.eshop.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> findAll();

    void createUser(User user);

    boolean updateUserById(UUID userId, User updatedUser);

    User getUserById(UUID userId);

    boolean deleteUserById(UUID userId);
}
