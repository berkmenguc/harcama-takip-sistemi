package com.example.spending_tracking_system.service;

import com.example.spending_tracking_system.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();
    User getById(Long userId);
    Optional<User> getUserByUserName(String userName);

    void deleteUser(Long userId);
    User createUser(User user);
    User updateUser(Long userId , User newUser);

    void registerUser(String username, String password);
}