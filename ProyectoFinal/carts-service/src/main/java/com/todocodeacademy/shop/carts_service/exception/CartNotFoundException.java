package com.todocodeacademy.shop.carts_service.exception;

public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException() {
    }

    public CartNotFoundException(String message) {
        super(message);
    }
}
