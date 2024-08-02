package com.todocodeacademy.shop.carts_service.service;

import java.util.List;

import com.todocodeacademy.shop.carts_service.dto.CartItemDto;
import com.todocodeacademy.shop.carts_service.model.Cart;

public interface ICartService {
    public Cart createCart();

    public List<Cart> findCarts();

    public Cart findCart(Long id);

    public Cart updateCart(CartItemDto cartItemDto);

    public void deleteCart(Long id);
}
