package com.example.ShopAnime.controller;


import com.example.ShopAnime.DTO.ProductDTO;
import com.example.ShopAnime.DTO.ProductResponse;
import com.example.ShopAnime.repository.ProductRepository;
import com.example.ShopAnime.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){

        ProductResponse response = productService.deleteProduct(id);

        if(response.isSuccess()){
            return new ResponseEntity<>(response.getMessage(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response.getMessage(),HttpStatus.UNAUTHORIZED);
        }


    }

}
