package com.example.customerservice.entities;

import lombok.Getter;

@Getter
public enum ProductType {
    ROASTED_COFFEE("ROASTED_COFFEE");

    private String type;

    ProductType(String type) {
        this.type = type;
    }
}
