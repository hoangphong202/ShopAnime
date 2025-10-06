package com.example.ShopAnime.config;

import com.example.ShopAnime.ShopAnimeApplication;
import com.example.ShopAnime.entity.AccountEntity;
import com.example.ShopAnime.entity.UserEntity;
import com.example.ShopAnime.repository.AccountRepository;
import com.example.ShopAnime.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AccountConfig implements CommandLineRunner {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (!accountRepository.findByUsername("admin").isPresent()) {


            AccountEntity accountAdmin = new AccountEntity();
            accountAdmin.setUsername("admin");
            accountAdmin.setPassword(passwordEncoder.encode("123")); // mã hóa password
            accountAdmin.setRole("ADMIN");
            accountRepository.save(accountAdmin);

            UserEntity user = new UserEntity();
            user.setName("Admin");
            user.setAccountEntity(accountAdmin);
            userRepository.save(user);

            System.out.println("Admin created: username=admin, password=123");
        }
    }
}
