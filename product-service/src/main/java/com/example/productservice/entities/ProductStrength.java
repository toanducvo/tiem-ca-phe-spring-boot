package com.example.productservice.entities;

import lombok.Getter;

@Getter
public enum ProductStrength {
    WHOLE_BEAN("WHOLE_BEAN"),
    DRIP_MACHINE("DRIP_MACHINE"),
    POUR_OVER("DRIP_MACHINE"),
    ESPRESSO("ESPRESSO"),
    PHIN("PHIN"),
    COLD_BREW("COLD_BREW");

    private String strength;

    ProductStrength(String strength) {
        this.strength = strength;
    }
}
