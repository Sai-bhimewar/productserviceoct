package com.scaler.productservice.controllers;

import com.scaler.productservice.dtos.FakeStoreCreateProductDto;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    }


    @PostMapping("/products")
    public Product createProduct(@RequestBody FakeStoreCreateProductDto requestDto) {
        return productService.CreateProduct(requestDto.getTitle(), requestDto.getDescription(), requestDto.getPrice(), requestDto.getCategory(), requestDto.getImage());
    }
}
