package com.scaler.productservice.services;

import com.scaler.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Product getProductDetails(Long id ) {

        return null;
    }
}
