package com.scaler.productservice.controllers;

import com.scaler.productservice.dtos.FakeStoreCreateProductDto;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long id) {

        return productService.getProductDetails(id);
//        Product product = productService.getProductDetails(id);
//        return new ResponseEntity<>(product, HttpStatusCode.valueOf(601));
    }


    @PostMapping("/products")
    public Product createProduct(@RequestBody FakeStoreCreateProductDto requestDto) {
        return productService.CreateProduct(requestDto.getTitle(), requestDto.getDescription(), requestDto.getPrice(), requestDto.getCategory(), requestDto.getImage());
//        Product product=productService.CreateProduct(requestDto.getTitle(), requestDto.getDescription(), requestDto.getPrice(), requestDto.getCategory(), requestDto.getImage());
//        return new ResponseEntity<>(product, HttpStatusCode.valueOf(401));
    }
}
