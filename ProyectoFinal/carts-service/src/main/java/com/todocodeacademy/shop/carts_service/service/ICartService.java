package com.todocodeacademy.shop.carts_service.service;

import java.util.List;

import com.todocodeacademy.shop.carts_service.dto.CartItemDto;
import com.todocodeacademy.shop.carts_service.model.Cart;
import com.todocodeacademy.shop.carts_service.response.CartResponse;

public interface ICartService {
    public Cart createCart();

    public List<Cart> findAllCarts();

    public CartResponse findCartResponse(Long id);

    public CartResponse addToCart(Long cartId, CartItemDto cartItemDto);

    public CartResponse removeFromCart(Long cartItemId);

    public void deleteCart(Long id);
}
