package com.todocodeacademy.shop.carts_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todocodeacademy.shop.carts_service.dto.CartItemDto;
import com.todocodeacademy.shop.carts_service.service.CartService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping()
    public ResponseEntity<?> findAllCarts() {
        return new ResponseEntity<>(cartService.findCarts(), HttpStatus.OK);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<?> findCart(@PathVariable Long cartId) {
        return new ResponseEntity<>(cartService.findCartResponse(cartId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createCart() {
        return new ResponseEntity<>(cartService.createCart(), HttpStatus.OK);
    }

    @PutMapping("/{cartId}")
    public ResponseEntity<?> addToCart(@PathVariable Long cartId, @RequestBody @Valid CartItemDto cartItemDto) {
        return new ResponseEntity<>(cartService.addToCart(cartId, cartItemDto), HttpStatus.OK);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<?> deleteCart(@PathVariable Long cartId) {
        cartService.deleteCart(cartId);
        return new ResponseEntity<>("Successfully deleted.", HttpStatus.OK);
    }

    @DeleteMapping("/items/{cartItemId}")
    public ResponseEntity<?> removeFromCart(@PathVariable Long cartItemId) {
        return new ResponseEntity<>(cartService.removeFromCart(cartItemId), HttpStatus.OK);
    }
}
