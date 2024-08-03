package com.todocodeacademy.shop.carts_service.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ValidationError {
    private String code;
    private String message;
}
