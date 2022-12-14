package com.kamilabiyev.productservice;

import com.kamilabiyev.productservice.domain.model.entity.Product;
import com.kamilabiyev.productservice.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@EnableEurekaClient
public class ProductServiceApplication {

    ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return (args) -> {
            if (productRepository.getCount() == 0) {
                productRepository.saveAll(List.of(Product.builder()
                        .name("T-Shirt")
                        .price(1000.5D)
                        .stockCount(15).build(), Product.builder()
                        .name("Jeans")
                        .price(1200.5D)
                        .stockCount(22).build(), Product.builder()
                        .name("Hat")
                        .price(620.99)
                        .stockCount(25).build()));
            }
        };
    }

}
