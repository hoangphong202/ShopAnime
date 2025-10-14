package com.example.ShopAnime.service.impl;

import com.example.ShopAnime.DTO.ProductResponse;
import com.example.ShopAnime.repository.ProductRepository;
import com.example.ShopAnime.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductResponse deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return new ProductResponse(true,"xoa san pham thanh cong");
        }
        return new ProductResponse(true,"xoa san pham that bai");
    }

}
