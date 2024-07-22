package com.example.spending_tracking_system.controller;

import com.example.spending_tracking_system.configurations.requests.RegistrationRequest;
import com.example.spending_tracking_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody RegistrationRequest request) {
        userService.registerUser(request.getUsername(), request.getPassword());
    }
}
