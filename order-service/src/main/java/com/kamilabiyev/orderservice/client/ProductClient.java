package com.kamilabiyev.orderservice.client;

import com.kamilabiyev.orderservice.domain.model.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("product-service")
public interface ProductClient {

    @GetMapping("/api/products/by-id")
    public ProductDto getById(@RequestParam(name = "productId") Long productId);
}
