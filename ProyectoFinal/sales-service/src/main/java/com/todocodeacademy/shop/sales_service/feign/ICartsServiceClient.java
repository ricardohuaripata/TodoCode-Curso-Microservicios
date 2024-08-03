package com.todocodeacademy.shop.sales_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.todocodeacademy.shop.sales_service.response.CartResponse;

@FeignClient(name = "carts-service", path = "/carts")
public interface ICartsServiceClient {
    @GetMapping("{cartId}")
    public CartResponse getCart(@PathVariable Long cartId);

    @DeleteMapping("{cartId}")
    public void deleteCart(@PathVariable Long cartId);
}
