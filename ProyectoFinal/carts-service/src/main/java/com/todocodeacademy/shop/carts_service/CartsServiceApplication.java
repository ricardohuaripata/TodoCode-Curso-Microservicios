package com.todocodeacademy.shop.carts_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CartsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartsServiceApplication.class, args);
	}

}
