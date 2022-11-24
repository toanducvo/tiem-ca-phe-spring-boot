package com.example.productservice.controllers;

import com.example.productservice.entities.Product;
import com.example.productservice.entities.ProductStrength;
import com.example.productservice.entities.ProductType;
import com.example.productservice.services.ProductService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = {"/{id}"})
    @Cacheable(value = "product", key = "#id")
    @Retry(name = "product", fallbackMethod = "getProductFallback")
    @CircuitBreaker(name = "product", fallbackMethod = "getProductFallback")
    @RateLimiter(name = "product")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping(value = {"", "/"})
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = {"/strength/{strength}", "/strength/{strength}/"})
    @Cacheable(value = "product", key = "#strength")
    public List<Product> getProductsByStrength(@PathVariable String strength) {
        return productService.getAllProductsByStrength(ProductStrength.valueOf(strength.toUpperCase()));
    }

    @GetMapping(value = {"/variety/{variety}", "/variety/{variety}/"})
    @Cacheable(value = "product", key = "#variety")
    public List<Product> getProductsByVariety(@PathVariable String variety) {
        return productService.getAllProductsByVariety(variety);
    }

    @GetMapping(value = {"/type/{type}", "/type/{type}/"})
    @Cacheable(value = "product", key = "#type")
    public List<Product> getProductByType(@PathVariable String type) {
        return productService.getAllProductsByType(ProductType.valueOf(type.toUpperCase()));
    }

    @PostMapping(value = {"", "/"})
    @Retry(name = "product-service", fallbackMethod = "addProductFallback")
    public void addProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

    public Product addProductFallback(Exception e) {
        System.out.println("addProductFallback called");
        return null;
    }

    public Product getProductFallback(Exception e) {
        System.out.println("getProductFallback called");
        return null;
    }
}
