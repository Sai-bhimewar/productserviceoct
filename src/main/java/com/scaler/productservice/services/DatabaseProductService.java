package com.scaler.productservice.services;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.CategoryRepository;
import com.scaler.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("databaseProductService")
public class DatabaseProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public DatabaseProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductDetails(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProductFromDatabse = productRepository.findById(id);
        if(optionalProductFromDatabse.isEmpty()) {
            //throw new ProductNotFoundException("Product not found");
            return null;
        }
        Product product=optionalProductFromDatabse.get();
        return product;
    }

    @Override
    public Product CreateProduct(String title, String description, String price, String category, String image) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(Double.parseDouble(price));
        product.setImageUrl(image);
        Category CategroyFromDatabase=categoryRepository.findByName(category);
        if(CategroyFromDatabase==null){
            Category category1=new Category();
            category1.setName(category);
            CategroyFromDatabase=categoryRepository.save(category1);
        }
        product.setCategory(CategroyFromDatabase);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
