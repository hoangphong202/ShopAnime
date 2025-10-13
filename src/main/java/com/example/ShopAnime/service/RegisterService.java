package com.example.ShopAnime.service;


import com.example.ShopAnime.DTO.LoginRequest;
import com.example.ShopAnime.DTO.RegisterRequest;
import com.example.ShopAnime.DTO.RegisterResponse;

public interface RegisterService {

     RegisterResponse register(RegisterRequest registerRequest);
}
