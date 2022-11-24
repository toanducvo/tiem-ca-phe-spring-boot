package com.example.productservice.converters;


import com.example.productservice.entities.ProductType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ProductTypeConverter implements AttributeConverter<ProductType, String> {
    @Override
    public String convertToDatabaseColumn(ProductType type) {
        if (type == null) {
            return null;
        }
        return type.getType();
    }

    @Override
    public ProductType convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }

        return Stream.of(ProductType.values())
                .filter(c -> c.getType().equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
