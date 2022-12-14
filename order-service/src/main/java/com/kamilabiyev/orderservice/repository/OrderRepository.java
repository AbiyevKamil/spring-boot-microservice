package com.kamilabiyev.orderservice.repository;

import com.kamilabiyev.orderservice.domain.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
