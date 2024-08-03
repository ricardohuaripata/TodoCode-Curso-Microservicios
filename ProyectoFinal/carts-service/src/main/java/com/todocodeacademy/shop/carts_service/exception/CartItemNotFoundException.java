package com.todocodeacademy.shop.carts_service.exception;

public class CartItemNotFoundException extends RuntimeException {
    public CartItemNotFoundException() {
    }

    public CartItemNotFoundException(String message) {
        super(message);
    }
}
