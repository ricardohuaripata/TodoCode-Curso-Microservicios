package com.todocodeacademy.shop.carts_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todocodeacademy.shop.carts_service.model.Cart;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {

}
