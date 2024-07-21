package com.example.spending_tracking_system.service;

import com.example.spending_tracking_system.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getById(Long userId);
    void deleteUser(Long userId);
    User createUser(User user);
    User updateUser(Long userId , User newUser);
}
