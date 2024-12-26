package com.scaler.productservice.models;


public class Product {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public Category getCategory() {
        return category;
    }
}
