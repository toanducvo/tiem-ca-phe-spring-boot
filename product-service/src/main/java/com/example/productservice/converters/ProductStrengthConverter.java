package com.example.productservice.converters;


import com.example.productservice.entities.ProductStrength;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ProductStrengthConverter implements AttributeConverter<ProductStrength, String> {
    @Override
    public String convertToDatabaseColumn(ProductStrength productStrength) {
        if (productStrength == null) {
            return null;
        }
        return productStrength.getStrength();
    }

    @Override
    public ProductStrength convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }

        return Stream.of(ProductStrength.values())
                .filter(c -> c.getStrength().equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
