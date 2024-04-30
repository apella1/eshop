package me.apella.eshop.service.impl;

import me.apella.eshop.model.User;
import me.apella.eshop.repository.UserRepository;
import me.apella.eshop.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean updateUserById(UUID userId, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setEmail(updatedUser.getEmail());
            user.setName(updatedUser.getName());
            user.setPassword(updatedUser.getPassword());
            user.setShippingAddress(updatedUser.getShippingAddress());
            userRepository.save(user);
            return true;
        }

        return false;
    }

    @Override
    public User getUserById(UUID userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public boolean deleteUserById(UUID userId) {
        Optional<User> optionalCustomer = userRepository.findById(userId);

        if (optionalCustomer.isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
