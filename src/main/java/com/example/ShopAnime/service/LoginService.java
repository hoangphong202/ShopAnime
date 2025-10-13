package com.example.ShopAnime.service;


import com.example.ShopAnime.DTO.LoginRequest;
import com.example.ShopAnime.DTO.LoginResponse;

public interface LoginService {
    LoginResponse login(LoginRequest loginRequest);
}
