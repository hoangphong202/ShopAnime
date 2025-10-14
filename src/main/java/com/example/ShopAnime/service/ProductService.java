package com.example.ShopAnime.service;

import com.example.ShopAnime.DTO.ProductResponse;
import com.example.ShopAnime.service.impl.ProductServiceImpl;

public interface ProductService {
    ProductResponse deleteProduct(Long id) ;

}
