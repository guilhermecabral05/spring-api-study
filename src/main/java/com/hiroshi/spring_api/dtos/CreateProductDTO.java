package com.hiroshi.spring_api.dtos;

import java.math.BigDecimal;

public record CreateProductDTO(String name, String description, BigDecimal price) {}
