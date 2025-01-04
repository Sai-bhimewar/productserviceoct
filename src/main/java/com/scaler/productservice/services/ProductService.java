package com.scaler.productservice.services;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;

import java.util.List;

public interface ProductService {

    public Product getProductDetails(Long id) throws ProductNotFoundException;
    public Product CreateProduct(String title, String description, String price,String category,String image);
    public List<Product> getAllProducts();
}
