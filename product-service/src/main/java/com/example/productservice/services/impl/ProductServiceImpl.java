package com.example.productservice.services.impl;

import com.example.productservice.entities.Product;
import com.example.productservice.entities.ProductStrength;
import com.example.productservice.entities.ProductType;
import com.example.productservice.repositories.ProductRepository;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAllProductsByStrength(ProductStrength strength) {
        return productRepository.findAllByStrength(strength);
    }

    @Override
    public List<Product> getAllProductsByVariety(String variety) {
        return productRepository.findAllByVariety(variety);
    }

    @Override
    public List<Product> getAllProductsByType(ProductType type) {
        return productRepository.findAllByType(type);
    }

}
