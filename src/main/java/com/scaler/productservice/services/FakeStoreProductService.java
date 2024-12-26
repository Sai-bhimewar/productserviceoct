package com.scaler.productservice.services;

import com.scaler.productservice.dtos.FakeStoreCreateProductDto;
import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductDetails(Long id ) {

        FakeStoreProductDto responseDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        Product product = new Product();
        product.setId(responseDto.getId());
        product.setTitle(responseDto.getName());
        product.setDescription(responseDto.getDescription());
        product.setPrice(Double.parseDouble(responseDto.getPrice()));
        product.setImageUrl(responseDto.getImage());
        Category category = new Category();
        category.setName(responseDto.getCategory());
        product.setCategory(category);

        return product;
    }

    @Override
    public Product CreateProduct(String title, String description, String price, String category, String image) {
        FakeStoreCreateProductDto requestDto =new FakeStoreCreateProductDto();
        requestDto.setTitle(title);
        requestDto.setDescription(description);
        requestDto.setPrice(price);
        requestDto.setCategory(category);
        requestDto.setImage(image);

        FakeStoreProductDto responseDto=
        restTemplate.postForObject("https://fakestoreapi.com/products",requestDto, FakeStoreProductDto.class);
        return responseDto.toProduct();
    }
}
