package com.kamilabiyev.productservice.service;


import com.kamilabiyev.productservice.domain.model.dto.ProductDto;

import java.util.List;

public interface ProductService {
    public List<ProductDto> getProducts();
    public ProductDto getProduct(Long id);
}
