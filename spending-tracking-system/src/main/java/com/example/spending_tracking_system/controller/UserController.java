package com.example.spending_tracking_system.controller;

import com.example.spending_tracking_system.models.User;
import com.example.spending_tracking_system.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User request) {
        Optional<User> user = service.getUserByUserName(request.getUserName());

        if (user.isEmpty()) {
            return ResponseEntity.badRequest().body("Geçersiz e-posta veya şifre");
        }
        User userr = user.get();


        if (!userr.getPassword().equals(request.getPassword())) {
            return ResponseEntity.badRequest().body("Geçersiz kullanıcı adı veya şifre");
        }
        return ResponseEntity.ok("Giriş başarılı!");
    }
    @GetMapping("/test-api")
    public String testApi(){
        return "Hello it works";
    }
}
