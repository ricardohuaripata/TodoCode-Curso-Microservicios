package com.todocodeacademy.shop.carts_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todocodeacademy.shop.carts_service.model.Cart;
import com.todocodeacademy.shop.carts_service.model.CartItem;

@Repository
public interface ICartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByCartAndProductId(Cart cart, Long productId);

}
