package com.todocodeacademy.shop.carts_service.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartItemDto {
    @NotNull
    private Long productId;
    @NotNull
    @Min(1)
    @Max(99)
    private Integer quantity;

}
