package com.example.ShopAnime.service.impl;

import com.example.ShopAnime.DTO.LoginRequest;
import com.example.ShopAnime.DTO.RegisterRequest;
import com.example.ShopAnime.DTO.RegisterResponse;
import com.example.ShopAnime.entity.AccountEntity;
import com.example.ShopAnime.entity.UserEntity;
import com.example.ShopAnime.repository.AccountRepository;
import com.example.ShopAnime.repository.UserRepository;
import com.example.ShopAnime.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.PrivateKey;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public RegisterResponse register(RegisterRequest registerRequest) {

        if(registerRequest.getName()==null||registerRequest.getName().trim().isEmpty()){
            return new RegisterResponse(false, "chưa nhập tên");
        }

        if(registerRequest.getUsername()==null||registerRequest.getUsername().trim().isEmpty()){
            return new RegisterResponse(false, "chưa nhập tai khoan");
        }

        if(registerRequest.getPassword()==null||registerRequest.getPassword().trim().isEmpty()){
            return new RegisterResponse(false, "chưa nhập mat khau");
        }

        UserEntity checkname = userRepository.findByName(registerRequest.getName()).orElse(null);
        if (checkname != null) {
                return new RegisterResponse(false, "ten nguoi dung da ton tai");
        }

        AccountEntity checkaccount = accountRepository.findByUsername(registerRequest.getUsername()).orElse(null);
        if (checkaccount != null) {
            return new RegisterResponse(false, "tai khoan da ton tai");
        }

        AccountEntity account = new AccountEntity();
        account.setUsername(registerRequest.getUsername());
        account.setPassword(passwordEncoder.encode(registerRequest.getPassword())); // mã hóa password
        account.setRole("USER");
        accountRepository.save(account);

        UserEntity user = new UserEntity();
        user.setName(registerRequest.getName());
        user.setAccountEntity(account);
        userRepository.save(user);

        return new RegisterResponse(true, "tao tai khoan thanh cong");

    }
}
