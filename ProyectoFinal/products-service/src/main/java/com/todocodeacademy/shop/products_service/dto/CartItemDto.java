package com.todocodeacademy.shop.products_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemDto {
    private Long id;
    private Long productId;
    private Integer quantity;
}
