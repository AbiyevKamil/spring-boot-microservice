package com.kamilabiyev.productservice.controller;

import com.kamilabiyev.productservice.domain.model.dto.ProductDto;
import com.kamilabiyev.productservice.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {

    ProductService productService;

    @GetMapping("/by-id")
    @SneakyThrows
    public ProductDto getById(@RequestParam(name = "productId") Long productId) {
        Thread.sleep(8*60*1000);
        return productService.getProduct(productId);
    }

    @GetMapping("")
    public List<ProductDto> get() {
        return productService.getProducts();
    }
}
