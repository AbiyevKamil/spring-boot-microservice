package com.kamilabiyev.orderservice.controller;

import com.kamilabiyev.orderservice.domain.model.dto.OrderDto;
import com.kamilabiyev.orderservice.domain.model.request.CreateOrderRequest;
import com.kamilabiyev.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

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
    @CircuitBreaker(name = "product", fallbackMethod = "fallBackMethod")
    @TimeLimiter(name = "product", fallbackMethod = "fallBackMethod")
    public CompletableFuture<Long> create(@RequestBody CreateOrderRequest createOrderRequest) {
        return CompletableFuture.supplyAsync(() -> orderService.create(createOrderRequest));
    }

    @SneakyThrows
    public CompletableFuture<Long> fallBackMethod(CreateOrderRequest createOrderRequest, RuntimeException exception) {
        return CompletableFuture.supplyAsync(() -> 0L);
    }

}
