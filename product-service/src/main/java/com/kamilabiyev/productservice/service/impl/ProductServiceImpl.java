package com.kamilabiyev.productservice.service.impl;

import com.kamilabiyev.productservice.domain.model.dto.ProductDto;
import com.kamilabiyev.productservice.repository.ProductRepository;
import com.kamilabiyev.productservice.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;


    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream()
                .map(product -> ProductDto.builder()
                        .productId(product.getProductId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .stockCount(product.getStockCount()).build())
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProduct(Long id) {
        var product = productRepository.findById(id).get();

        return ProductDto.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .price(product.getPrice())
                .stockCount(product.getStockCount()).build();
    }
}
