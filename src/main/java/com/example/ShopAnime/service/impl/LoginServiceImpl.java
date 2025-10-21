package com.example.ShopAnime.service.impl;

import com.example.ShopAnime.DTO.LoginRequest;
import com.example.ShopAnime.DTO.LoginResponse;
import com.example.ShopAnime.entity.AccountEntity;
import com.example.ShopAnime.repository.AccountRepository;
import com.example.ShopAnime.service.LoginService;
import com.example.ShopAnime.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtils jwtUtils;

    public LoginResponse login(LoginRequest loginRequest){

        AccountEntity account = accountRepository.findByUsername(loginRequest.getUsername()).orElse(null);

        if (account == null) {
            return new LoginResponse(false, "username không tồn tại");
        }

        if (passwordEncoder.matches(loginRequest.getPassword(), account.getPassword())) {

            String token = jwtUtils.generateToken(loginRequest.getUsername());
            return new LoginResponse(true,"login thành công", account.getRole(), token);
        } else {
            return new LoginResponse(false,"sai mật khẩu");
        }

    }
}
