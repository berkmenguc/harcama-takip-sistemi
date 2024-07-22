package com.example.spending_tracking_system.service;

import com.example.spending_tracking_system.exceptions.UserNotFoundException;
import com.example.spending_tracking_system.models.User;
import com.example.spending_tracking_system.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public User getById(Long userId) {
        return repository.findById(userId).orElseThrow(() -> new UserNotFoundException("Kullanıcı bulunamadı"));
    }

    @Override
    public Optional<User> getUserByUserName(String userName) {
        return repository.findByUserName(userName);
    }

    @Override
    public void deleteUser(Long userId) {
        repository.deleteById(userId);
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(Long userId, User newUser) {
        Optional<User> user = repository.findById(userId);
        if(user.isPresent()){
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            return foundUser;
        } else {
            return null;

        }
    }
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void registerUser(String username, String rawPassword) {
        if (repository.findByUserName(username).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        String encodedPassword = passwordEncoder.encode(rawPassword);
        User user = new User();
        user.setUserName(username);
        user.setPassword(encodedPassword);

        repository.save(user);
    }

}