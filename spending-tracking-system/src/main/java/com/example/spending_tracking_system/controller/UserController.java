package com.example.spending_tracking_system.controller;

import com.example.spending_tracking_system.models.User;
import com.example.spending_tracking_system.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService service;
    @GetMapping("/get-all")
    public List<User> getAllUser(){
        return service.getUsers();
    }
    @GetMapping("/{userId}")
    public User findUserById(@PathVariable("userId") Long userId){
        return service.getById(userId);
    }
    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable("userId") Long userId){
        service.deleteUser(userId);
    }
    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return service.createUser(user);
    }
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable("userId") Long userId, @RequestBody User newUser){
        return service.updateUser(userId , newUser);
    }
}
