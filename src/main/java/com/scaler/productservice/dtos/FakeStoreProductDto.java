package com.scaler.productservice.dtos;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;

public class FakeStoreProductDto {
    private Long id;
    private String name;
    private String description;
    private String category;
    private String price;
    private String image;

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getCategory() {
        return category;
    }
    public String getPrice() {
        return price;
    }
    public String getImage() {
        return image;
    }

    public Product toProduct() {
        Product product = new Product();
        product.setTitle(getName());
        product.setDescription(getDescription());
        product.setPrice(Double.parseDouble(getPrice()));
        product.setImageUrl(getImage());
        Category category = new Category();
        category.setName(getCategory());
        product.setCategory(category);
        return product;
    }
}
