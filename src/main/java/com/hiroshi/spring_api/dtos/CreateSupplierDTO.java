package com.hiroshi.spring_api.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateSupplierDTO {
    @NotBlank
    private String name;
}
