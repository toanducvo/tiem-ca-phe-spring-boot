package com.example.productservice.repositories;

import com.example.productservice.entities.Product;
import com.example.productservice.entities.ProductStrength;
import com.example.productservice.entities.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByStrength(ProductStrength strength);

    List<Product> findAllByVariety(String variety);

    List<Product> findAllByType(ProductType type);
}
