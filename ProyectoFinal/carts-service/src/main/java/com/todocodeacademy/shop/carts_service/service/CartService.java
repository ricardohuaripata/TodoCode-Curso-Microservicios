package com.todocodeacademy.shop.carts_service.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.shop.carts_service.dto.CartItemDto;
import com.todocodeacademy.shop.carts_service.model.Cart;
import com.todocodeacademy.shop.carts_service.model.CartItem;
import com.todocodeacademy.shop.carts_service.repository.ICartItemRepository;
import com.todocodeacademy.shop.carts_service.repository.ICartRepository;

@Service
public class CartService implements ICartService {

    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private ICartItemRepository cartItemRepository;

    @Override
    public Cart createCart() {
        Cart newCart = new Cart();
        Date currentDate = new Date();

        newCart.setCreatedAt(currentDate);
        newCart.setUpdatedAt(currentDate);
        return cartRepository.save(newCart);
    }

    @Override
    public List<Cart> findCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findCart(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public Cart updateCart(CartItemDto cartItemDto) {

        Cart cart = findCart(cartItemDto.getCartId());

        // TODO check find product by id

        if (cart == null) {
            return null;
        }

        CartItem newCartItem = new CartItem();
        newCartItem.setCart(cart);
        newCartItem.setProductId(cartItemDto.getProductId());
        newCartItem.setQuantity(cartItemDto.getQuantity());
        cartItemRepository.save(newCartItem);

        cart.getItems().add(newCartItem);
        cart.setUpdatedAt(new Date());

        return cartRepository.save(cart);
    }

    @Override
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

}
