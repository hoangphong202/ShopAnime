package com.example.ShopAnime.service.impl;

import com.example.ShopAnime.DTO.ProductDTO;
import com.example.ShopAnime.DTO.ProductRequest;
import com.example.ShopAnime.DTO.ProductResponse;
import com.example.ShopAnime.entity.ProductEntity;
import com.example.ShopAnime.repository.ProductRepository;
import com.example.ShopAnime.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductResponse addProduct(ProductRequest productRequest) {
        try {
            ProductEntity product = new ProductEntity();
            product.setName(productRequest.getName());
            product.setPrice(productRequest.getPrice());
            product.setDescription(productRequest.getDescription());
            product.setStock(productRequest.getStock());
            productRepository.save(product);

            return new ProductResponse(true, "Them san pham thanh cong", product);
        } catch (Exception e) {
            e.printStackTrace();

            return new ProductResponse(false, "Thêm sản phẩm thất bại: " + e.getMessage());

        }
    }

    public ProductResponse listProduct(){
        List<ProductEntity> entities = productRepository.findAll();
        List<ProductDTO> result = new ArrayList<>();

        for (ProductEntity product : entities) {
            ProductDTO dto = new ProductDTO();
            dto.setId(product.getId());
            dto.setName(product.getName());
            dto.setPrice(product.getPrice());
            dto.setStock(product.getStock());
            dto.setDescription(product.getDescription());
            result.add(dto);
        }

        return new ProductResponse(true,"danh sach san pham", result);

    }

    public ProductResponse deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return new ProductResponse(true,"xoa san pham thanh cong");
        }
        return new ProductResponse(true,"xoa san pham that bai");
    }


}
