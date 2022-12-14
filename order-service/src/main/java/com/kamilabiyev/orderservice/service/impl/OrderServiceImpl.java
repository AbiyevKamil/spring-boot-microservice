package com.kamilabiyev.orderservice.service.impl;

import com.kamilabiyev.orderservice.client.ProductClient;
import com.kamilabiyev.orderservice.domain.model.dto.OrderDto;
import com.kamilabiyev.orderservice.domain.model.entity.Order;
import com.kamilabiyev.orderservice.domain.model.request.CreateOrderRequest;
import com.kamilabiyev.orderservice.repository.OrderRepository;
import com.kamilabiyev.orderservice.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    ProductClient productClient;

    @Override
    public OrderDto getOrder(Long id) {
        var order = orderRepository.findById(id).get();

        return OrderDto.builder()
                .orderId(order.getOrderId())
                .orderedAt(order.getOrderedAt())
                .productId(order.getProductId())
                .userId(order.getUserId())
                .countOfProduct(order.getCountOfProduct()).build();
    }

    @SneakyThrows
    @Override
    public Long create(CreateOrderRequest createOrderRequest) {
        var check = productClient.getById(createOrderRequest.getProductId());
        if (check.getStockCount() >= createOrderRequest.getCountOfProduct()) {
            var order = Order.builder().productId(createOrderRequest.getProductId())
                    .countOfProduct(createOrderRequest.getCountOfProduct())
                    // Todo: get authenticated user id
                    .userId(0L)
                    .build();
            order = orderRepository.save(order);
            // Todo: send notification
            return order.getOrderId();
        }
        throw new Exception("Product count is less than needed.");
    }
}
