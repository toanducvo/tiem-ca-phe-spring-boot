package com.example.customerservice.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_details")
@IdClass(OrderDetail.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetail implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "qty")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "total_line")
    private double totalLine;
}
