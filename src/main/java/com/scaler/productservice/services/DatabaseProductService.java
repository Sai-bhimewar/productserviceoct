package com.scaler.productservice.services;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("databaseService")
public class DatabaseProductService implements ProductService {
    private ProductRepository productRepository;

    public DatabaseProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductDetails(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product CreateProduct(String title, String description, String price, String category, String image) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
