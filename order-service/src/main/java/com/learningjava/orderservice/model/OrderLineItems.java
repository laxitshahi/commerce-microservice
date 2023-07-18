package com.learningjava.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity // Entities are POJOs that represent data that can be persisted in the DB
@Table(name="t_order_line_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// Specifics the details of each item in the order
public class OrderLineItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremented DB on insertion in DB
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
