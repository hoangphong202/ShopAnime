package com.example.ShopAnime.repository;

import com.example.ShopAnime.entity.AccountEntity;
import com.example.ShopAnime.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
    Optional<AccountEntity> findByUsername(String username);

}
