package com.hiroshi.spring_api.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateSupplierDTO {
    @NotBlank
    private String name;
}
