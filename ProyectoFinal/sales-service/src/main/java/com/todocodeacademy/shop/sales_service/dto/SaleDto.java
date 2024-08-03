package com.todocodeacademy.shop.sales_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaleDto {
    @NotNull
    private Long cartId;

    @NotBlank
    @Size(max = 64)
    private String firstName;

    @NotBlank
    @Size(max = 64)
    private String lastName;

    @NotBlank
    @Size(max = 64)
    private String country;

    @NotBlank
    @Size(max = 64)
    private String city;

    @NotBlank
    @Size(max = 10)
    private String postalCode;

    @NotBlank
    @Size(max = 256)
    private String addressLine1;

    @NotBlank
    @Size(max = 256)
    private String addressLine2;

    @NotBlank
    @Size(max = 256)
    private String contactEmail;

    @NotBlank
    @Size(max = 20)
    private String contactPhone;
}
