package com.example.spending_tracking_system.controller;

import com.google.common.net.HttpHeaders;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @GetMapping("/secureAPI")
    public ResponseEntity securedApi(@RequestHeader org.springframework.http.HttpHeaders headers) {
        if (headers.containsKey(com.google.common.net.HttpHeaders.AUTHORIZATION)) {
            String authorizationHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);
            if (authorizationHeader.startsWith("Basic ")) {
                return new ResponseEntity("Authentication passed", HttpStatus.OK);
            }
        }
        return new ResponseEntity("Unauthorized", HttpStatus.UNAUTHORIZED);
    }
}
