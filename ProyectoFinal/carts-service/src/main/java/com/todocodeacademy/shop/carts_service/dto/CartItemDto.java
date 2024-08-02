package com.todocodeacademy.shop.carts_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartItemDto {
    @NotNull
    private Long cartId;
    @NotNull
    private Long productId;
    @NotNull
    private int quantity;

}
