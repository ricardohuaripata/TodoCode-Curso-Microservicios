package com.todocodeacademy.shop.carts_service.service;

import java.util.List;

import com.todocodeacademy.shop.carts_service.dto.CartItemDto;
import com.todocodeacademy.shop.carts_service.model.Cart;
import com.todocodeacademy.shop.carts_service.model.CartItem;
import com.todocodeacademy.shop.carts_service.response.CartResponse;

public interface ICartService {
    public Cart createCart();

    public List<Cart> findCarts();

    public Cart findCart(Long id);

    public CartResponse getCartResponse(Long id);

    public CartItem findCartItem(Long id);

    public Cart addToCart(Long cartId, CartItemDto cartItemDto);

    public Cart removeFromCart(Long cartItemId);

    public void deleteCart(Long id);
}
