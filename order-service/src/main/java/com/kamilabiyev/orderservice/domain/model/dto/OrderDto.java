package com.kamilabiyev.orderservice.domain.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private Long orderId;
    private Timestamp orderedAt;
    private Integer countOfProduct;
    private Long userId;
    private Long productId;
}
