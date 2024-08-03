package com.todocodeacademy.shop.sales_service.exception;

public class SaleNotFoundException extends RuntimeException {
    public SaleNotFoundException() {
    }

    public SaleNotFoundException(String message) {
        super(message);
    }
}
