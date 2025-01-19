package com.hiroshi.spring_api.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateProductDTO {

    @NotBlank
    private String name;

    @NotBlank(message = "Descrição é obrigatória")
    private String description;

    @NotBlank
    private BigDecimal price;

    @NotBlank
    private String supplierId;

}
