package com.hiroshi.spring_api.dtos;

import com.hiroshi.spring_api.entities.SupplierEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class SupplierDTO {

    private UUID id;
    private String name;

    public SupplierDTO(SupplierEntity supplier) {
        this.id = supplier.getId();
        this.name = supplier.getName();
    }
}
