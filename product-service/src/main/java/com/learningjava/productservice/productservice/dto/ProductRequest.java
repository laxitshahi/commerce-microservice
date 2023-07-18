package com.learningjava.productservice.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

// DTO :: Data Transfer object
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    // ID is created by mongodb
    private  String  name;
    private  String description;
    private BigDecimal price;
}
