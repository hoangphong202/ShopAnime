package com.example.ShopAnime.repository;

import com.example.ShopAnime.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
