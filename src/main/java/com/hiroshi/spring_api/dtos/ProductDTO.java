package com.hiroshi.spring_api.dtos;

import com.hiroshi.spring_api.entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private SupplierDTO supplier;

    public ProductDTO(ProductEntity product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.supplier = new SupplierDTO(product.getSupplier());
    }
}