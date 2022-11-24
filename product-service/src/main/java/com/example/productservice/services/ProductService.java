package com.example.productservice.services;

import com.example.productservice.entities.Product;
import com.example.productservice.entities.ProductStrength;
import com.example.productservice.entities.ProductType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    void createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    List<Product> getAllProductsByStrength(ProductStrength strength);

    List<Product> getAllProductsByVariety(String variety);

    List<Product> getAllProductsByType(ProductType type);
}
