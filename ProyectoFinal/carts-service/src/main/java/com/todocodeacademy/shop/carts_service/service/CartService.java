package com.todocodeacademy.shop.carts_service.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.shop.carts_service.dto.CartItemDto;
import com.todocodeacademy.shop.carts_service.exception.CartItemNotFoundException;
import com.todocodeacademy.shop.carts_service.exception.CartNotFoundException;
import com.todocodeacademy.shop.carts_service.feign.IProductsServiceClient;
import com.todocodeacademy.shop.carts_service.model.Cart;
import com.todocodeacademy.shop.carts_service.model.CartItem;
import com.todocodeacademy.shop.carts_service.model.Product;
import com.todocodeacademy.shop.carts_service.repository.ICartItemRepository;
import com.todocodeacademy.shop.carts_service.repository.ICartRepository;
import com.todocodeacademy.shop.carts_service.response.CartResponse;

@Service
public class CartService implements ICartService {

    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private ICartItemRepository cartItemRepository;

    @Autowired
    private IProductsServiceClient productsServiceClient;

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
        return cartRepository.findById(id).orElseThrow(CartNotFoundException::new);
    }

    @Override
    public CartResponse getCartResponse(Long id) {
        Cart cart = this.findCart(id);
        return productsServiceClient.buildCartResponse(cart);
    }

    @Override
    public Cart addToCart(Long cartId, CartItemDto cartItemDto) {

        Cart cart = this.findCart(cartId);

        Product product = productsServiceClient.getProduct(cartItemDto.getProductId());

        CartItem cartItem = cartItemRepository.findByCartAndProductId(cart, product.getId());

        // Si el artículo ya existe en el carrito
        if (cartItem != null) {
            cartItem.setQuantity(cartItemDto.getQuantity());
            cartItemRepository.save(cartItem);

        } else {
            CartItem newCartItem = new CartItem();
            newCartItem.setCart(cart);
            newCartItem.setProductId(product.getId());
            newCartItem.setQuantity(cartItemDto.getQuantity());
            cartItemRepository.save(newCartItem);
        }

        cart.setUpdatedAt(new Date());

        return cartRepository.save(cart);
    }

    @Override
    public void deleteCart(Long id) {
        Cart cart = this.findCart(id);
        cartRepository.delete(cart);
    }

    @Override
    public Cart removeFromCart(Long cartItemId) {
        CartItem cartItem = this.findCartItem(cartItemId);
        Cart cart = this.findCart(cartItem.getCart().getId());

        cartItemRepository.delete(cartItem);
        cart.setUpdatedAt(new Date());

        return cartRepository.save(cart);
    }

    @Override
    public CartItem findCartItem(Long id) {
        return cartItemRepository.findById(id).orElseThrow(CartItemNotFoundException::new);
    }

}
