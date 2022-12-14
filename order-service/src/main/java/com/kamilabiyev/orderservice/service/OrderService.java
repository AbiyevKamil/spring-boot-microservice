package com.kamilabiyev.orderservice.service;


import com.kamilabiyev.orderservice.domain.model.dto.OrderDto;
import com.kamilabiyev.orderservice.domain.model.request.CreateOrderRequest;

public interface OrderService {
    public OrderDto getOrder(Long id);
    public Long create(CreateOrderRequest createOrderRequest);
}
