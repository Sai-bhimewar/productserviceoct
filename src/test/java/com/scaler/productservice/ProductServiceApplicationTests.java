package com.scaler.productservice;

import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.ProductRepository;
import com.scaler.productservice.repositories.projections.ProductTitleAndDescription;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void Test(){
        List<Product> products = productRepository.findByCategory_Name("Earphones");
        System.out.println(products.get(0).getDescription());
    }

    @Test
    public void Test2(){
        Product p = productRepository.getProductDetails("Laptop");
        System.out.println(p.getTitle()+","+p.getDescription()+","+p.getPrice());
    }

    @Test
    public void Test3(){
        ProductTitleAndDescription p = productRepository.getProductDetails2(1L);
        System.out.println(p.getTitle()+","+p.getDescription());
    }

}
