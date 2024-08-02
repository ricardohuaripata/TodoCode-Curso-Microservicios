package com.todocodeacademy.shop.products_service.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
    @NotBlank
    private String name;
    @NotBlank
    private String brand;
    @NotNull
    @DecimalMin(value = "0.01", message = "The minimum price allowed is 0.01")
    @DecimalMax(value = "100000.00", message = "The maximum price allowed is 100000.00")
    private BigDecimal price;
}
