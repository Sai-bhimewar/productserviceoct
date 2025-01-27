package com.scaler.productservice;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.CategoryRepository;
import com.scaler.productservice.repositories.ProductRepository;
import com.scaler.productservice.repositories.projections.ProductTitleAndDescription;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

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

//    @Test
//    @Transactional
//    public void Test4(){
//        Category category=categoryRepository.findById(1);
//        System.out.println(category.getName());
//        System.out.println(category.getProducts());
//    }

}
