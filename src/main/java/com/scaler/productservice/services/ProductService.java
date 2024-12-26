package com.scaler.productservice.services;

import com.scaler.productservice.models.Product;

public interface ProductService {

    public Product getProductDetails(Long id);
    public Product CreateProduct(String title, String description, String price,String category,String image);
}
