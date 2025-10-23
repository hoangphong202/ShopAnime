package com.example.ShopAnime.controller;


import com.example.ShopAnime.DTO.ProductDTO;
import com.example.ShopAnime.DTO.ProductRequest;
import com.example.ShopAnime.DTO.ProductResponse;
import com.example.ShopAnime.repository.ProductRepository;
import com.example.ShopAnime.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("")
    public ResponseEntity<?> listProduct(){
        ProductResponse response = productService.listProduct();
        if(response.isSuccess()){

            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response.getMessage(),HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@Valid @ModelAttribute ProductRequest productRequest) {

        ProductResponse response = productService.addProduct(productRequest);

        if(response.isSuccess()){
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else
            return new ResponseEntity<>(response,HttpStatus.UNAUTHORIZED);
    }

    @PutMapping("/add")
    public ResponseEntity<?> editProduct(@Valid @ModelAttribute ProductRequest productRequest) {

        ProductResponse response = productService.addProduct(productRequest);

        if(response.isSuccess()){
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else
            return new ResponseEntity<>(response,HttpStatus.UNAUTHORIZED);
    }

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
