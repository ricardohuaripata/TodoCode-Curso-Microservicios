package com.todocodeacademy.shop.carts_service.service;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.todocodeacademy.shop.carts_service.response.CartItemResponse;
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
    public List<Cart> findAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public CartResponse findCartResponse(Long id) {
        Cart cart = this.findCart(id);
        return this.buildCartResponse(cart);
    }

    @Override
    public CartResponse addToCart(Long cartId, CartItemDto cartItemDto) {

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

        CartResponse cartResponse = buildCartResponse(cartRepository.save(cart));
        return cartResponse;
    }

    @Override
    public void deleteCart(Long id) {
        Cart cart = this.findCart(id);
        cartRepository.delete(cart);
    }

    @Override
    public CartResponse removeFromCart(Long cartItemId) {
        CartItem cartItem = this.findCartItem(cartItemId);
        Cart cart = this.findCart(cartItem.getCart().getId());

        cartItemRepository.delete(cartItem);
        cart.setUpdatedAt(new Date());

        CartResponse cartResponse = buildCartResponse(cartRepository.save(cart));

        return cartResponse;
    }

    private CartItem findCartItem(Long id) {
        return cartItemRepository.findById(id).orElseThrow(CartItemNotFoundException::new);
    }

    private Cart findCart(Long id) {
        return cartRepository.findById(id).orElseThrow(CartNotFoundException::new);
    }

    private CartResponse buildCartResponse(Cart cart) {
        ArrayList<Long> productsIds = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            productsIds.add(item.getProductId());
        }
        // Extraemos los productos del servicio productos
        List<Product> products = productsServiceClient.getProducts(productsIds);

        CartResponse cartResponse = new CartResponse();
        cartResponse.setId(cart.getId());
        cartResponse.setCreatedAt(cart.getCreatedAt());
        cartResponse.setUpdatedAt(cart.getUpdatedAt());

        List<CartItemResponse> cartItemsResponse = new ArrayList<>();
        BigDecimal totalPrice = BigDecimal.ZERO;
        Integer totalQuantity = 0;

        for (CartItem item : cart.getItems()) {

            for (Product product : products) {
                if (product.getId() == item.getProductId()) {
                    BigDecimal itemTotalPrice = product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));

                    totalPrice = totalPrice.add(itemTotalPrice);
                    totalQuantity += item.getQuantity();

                    CartItemResponse cartItemResponse = new CartItemResponse();
                    cartItemResponse.setId(item.getId());
                    cartItemResponse.setQuantity(item.getQuantity());
                    cartItemResponse.setProduct(product);

                    cartItemsResponse.add(cartItemResponse);
                    break;
                }
            }
        }

        cartResponse.setItems(cartItemsResponse);
        cartResponse.setTotalPrice(totalPrice);
        cartResponse.setTotalQuantity(totalQuantity);

        return cartResponse;
    }

}
