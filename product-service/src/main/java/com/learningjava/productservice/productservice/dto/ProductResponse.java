package com.learningjava.productservice.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    // Though the ProductResponse is the same as the model, we should not just use it since updates to the model would affect the response
    private String id;
    private  String  name;
    private  String description;
    private BigDecimal price;
}
