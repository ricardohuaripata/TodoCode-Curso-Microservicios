package com.todocodeacademy.shop.sales_service.exception;

public class NoItemsToPayException extends RuntimeException {
    public NoItemsToPayException() {
    }

    public NoItemsToPayException(String message) {
        super(message);
    }
}
