package com.kamilabiyev.productservice.repository;

import com.kamilabiyev.productservice.domain.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select count(p) from Product p")
    Long getCount();
}
