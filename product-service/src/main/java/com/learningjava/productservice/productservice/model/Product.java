package com.learningjava.productservice.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "product") // Will be stored in as documents in a collection named "product"
@AllArgsConstructor // Generates constructor with parameters for all fields in class
@NoArgsConstructor // Generates constructor with no parameters
@Builder
@Data // generates getter/setter methods + toString(), equals(), and hashCode()
public class Product {
    @Id
    private  String id;
    private  String  name;
    private  String description;
    private BigDecimal price;
}
