package com.example.ShopAnime.controller;

import com.example.ShopAnime.DTO.LoginRequest;
import com.example.ShopAnime.DTO.LoginResponse;
import com.example.ShopAnime.service.LoginService;
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



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse response = loginService.login(loginRequest);
        if (response.isSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
