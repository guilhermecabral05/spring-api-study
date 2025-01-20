package com.hiroshi.spring_api.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateSupplierDTO {
    @NotBlank(message = "Nome é obrigatorio")
    private String name;
}
