package com.learningjava.orderservice.service;

import com.learningjava.orderservice.dto.OrderLineItemsDto;
import com.learningjava.orderservice.dto.OrderRequest;
import com.learningjava.orderservice.model.Order;
import com.learningjava.orderservice.model.OrderLineItems;
import com.learningjava.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

// Business Logic
@Service
@RequiredArgsConstructor
@Transactional // Make service a transaction?
public class OrderService {

    // MAKE SURE IT IS FINAL OR IT WILL BE NULL
    private final OrderRepository orderRepository;

    // We are just posting the order, not doing the actual transaction
    public Order placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString()); // We create a random order number (we dont care)

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto) // === orderLineItemsDto -> mapToDto(OrderLineItemsDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);

        orderRepository.save(order);

        return order;
    }
    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto){
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}