package com.scaler.productservice.repositories;

import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.projections.ProductTitleAndDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);

    @Override
    Optional<Product> findById(Long id);

    @Override
    List<Product> findAll();

    List<Product> findByCategory_Name(String name);

    @Query("select p from Product p where p.category.name= :categoryname")
    Product getProductDetails(@Param("categoryname") String category);

    @Query(value = "select title,description from product where id= :id",nativeQuery = true)
    ProductTitleAndDescription getProductDetails2(@Param("id") Long id);
}
