package com.todocodeacademy.max_rep_calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MaxRepCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaxRepCalculatorApplication.class, args);
	}

}
