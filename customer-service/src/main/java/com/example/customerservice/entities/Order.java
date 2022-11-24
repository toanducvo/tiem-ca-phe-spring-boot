package com.example.customerservice.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "sub_total")
    private double subTotal;

    @Column(name = "total")
    private double total;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    @ToString.Exclude
    private Set<OrderDetail> orderDetails = new HashSet<>();
}
