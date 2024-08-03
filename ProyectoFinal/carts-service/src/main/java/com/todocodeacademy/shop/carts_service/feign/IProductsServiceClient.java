package com.todocodeacademy.shop.carts_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.todocodeacademy.shop.carts_service.model.Product;

@FeignClient(name = "products-service", path = "/products")
public interface IProductsServiceClient {

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable Long productId);

    @PostMapping("/find")
    public List<Product> getProducts(@RequestBody List<Long> productIds);

}
