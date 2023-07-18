package com.learningjava.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Default generation type --> lets persistence provide generation type
    private Long id;
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL) // On action, such as delete -> do it to all items
    private List<OrderLineItems> orderLineItemsList;
}
