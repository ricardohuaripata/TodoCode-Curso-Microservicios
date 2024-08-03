package com.todocodeacademy.shop.carts_service.response;

import com.todocodeacademy.shop.carts_service.model.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemResponse {
    private Long id;
    private Product product;
    private Integer quantity;
}
