package com.example.ShopAnime.repository;

import com.example.ShopAnime.entity.AccountEntity;
import com.example.ShopAnime.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByName(String name);


}
