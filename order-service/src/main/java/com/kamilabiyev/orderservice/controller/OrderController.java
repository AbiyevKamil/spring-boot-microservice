package com.kamilabiyev.orderservice.controller;

import com.kamilabiyev.orderservice.domain.model.dto.OrderDto;
import com.kamilabiyev.orderservice.domain.model.request.CreateOrderRequest;
import com.kamilabiyev.orderservice.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class OrderController {
    OrderService orderService;

    @GetMapping("")
    public OrderDto get(@RequestParam(name = "orderId") Long orderId) {
        return orderService.getOrder(orderId);
    }

    @PostMapping("")
    public Long create(@RequestBody CreateOrderRequest createOrderRequest) {
        return orderService.create(createOrderRequest);
    }

}
