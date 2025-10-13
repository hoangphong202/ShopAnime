package com.example.ShopAnime.repository;

import com.example.ShopAnime.entity.AccountEntity;
import com.example.ShopAnime.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findByUsername(String username);

}
