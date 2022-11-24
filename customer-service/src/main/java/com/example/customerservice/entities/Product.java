package com.example.customerservice.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product implements Serializable {
    @Column(name = "weight")
    private final double weight = 0.25;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ProductType type;
    @Column(name = "strength")
    @Enumerated(EnumType.STRING)
    private ProductStrength strength;
    @Column(name = "variety")
    private String variety;
    @Column(name = "price")
    private double price;
}
