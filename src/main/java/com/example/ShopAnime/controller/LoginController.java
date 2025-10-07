package com.example.ShopAnime.controller;

import com.example.ShopAnime.DTO.LoginRequest;
import com.example.ShopAnime.service.LoginService;
import com.example.ShopAnime.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/home")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private JWTUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        boolean success = loginService.login(loginRequest);
        if (success) {
            String token = jwtUtils.generateToken(loginRequest.getUsername());
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("token", token);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }
}
