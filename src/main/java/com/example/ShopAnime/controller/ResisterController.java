package com.example.ShopAnime.controller;

import com.example.ShopAnime.DTO.LoginRequest;
import com.example.ShopAnime.DTO.RegisterRequest;
import com.example.ShopAnime.DTO.RegisterResponse;
import com.example.ShopAnime.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/home")
public class ResisterController {

    @Autowired
    private RegisterService registerService;



    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        RegisterResponse response  = registerService.register(registerRequest);
        if (response .isSuccess()) {
            return new ResponseEntity<>(response.getMessage(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
