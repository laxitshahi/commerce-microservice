package com.learningjava.orderservice.controller;

import com.learningjava.orderservice.dto.OrderRequest;
import com.learningjava.orderservice.model.Order;
import com.learningjava.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // If field data is incorrect (case-sensitive) the value will just be null (or if structure is incorrect)
    public Order placeOrder(@RequestBody OrderRequest orderRequest) {
        // For saftry you probably don't want to send the orderId and orderNumber back
        // So you could create a Dto here and add that functionality
        return orderService.placeOrder(orderRequest);
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public String getOrder(){
//        return "HELLO YOUR ODER IS HERE";
//    }
}
