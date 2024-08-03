package com.todocodeacademy.shop.products_service.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.shop.products_service.dto.CartDto;
import com.todocodeacademy.shop.products_service.dto.CartItemDto;
import com.todocodeacademy.shop.products_service.dto.ProductDto;
import com.todocodeacademy.shop.products_service.exception.ProductNotFoundException;
import com.todocodeacademy.shop.products_service.model.Product;
import com.todocodeacademy.shop.products_service.repository.IProductRepository;
import com.todocodeacademy.shop.products_service.response.CartItemResponse;
import com.todocodeacademy.shop.products_service.response.CartResponse;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Product saveProduct(ProductDto productDto) {
        Product newProduct = new Product();
        Date currentDate = new Date();
        newProduct.setName(productDto.getName());
        newProduct.setBrand(productDto.getBrand());
        newProduct.setPrice(productDto.getPrice());
        newProduct.setCreatedAt(currentDate);
        newProduct.setUpdatedAt(currentDate);

        return productRepository.save(newProduct);
    }

    @Override
    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProduct(Long id) {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public Product updateProduct(Long id, ProductDto productDto) {
        Product targetProduct = this.findProduct(id);

        targetProduct.setName(productDto.getName());
        targetProduct.setBrand(productDto.getBrand());
        targetProduct.setPrice(productDto.getPrice());
        targetProduct.setUpdatedAt(new Date());
        return productRepository.save(targetProduct);

    }

    @Override
    public void deleteProduct(Long id) {
        Product targetProduct = this.findProduct(id);
        productRepository.delete(targetProduct);
    }

    @Override
    public CartResponse buildCartResponse(CartDto cart) {
        CartResponse cartResponse = new CartResponse();
        cartResponse.setId(cart.getId());
        //cartResponse.setItems(cart.getItems());
        cartResponse.setCreatedAt(cart.getCreatedAt());
        cartResponse.setUpdatedAt(cart.getUpdatedAt());

        List<CartItemResponse> cartItemsResponse = new ArrayList<>();
        BigDecimal totalPrice = BigDecimal.ZERO;
        Integer totalQuantity = 0;

        for (CartItemDto item : cart.getItems()) {
            Product product = this.findProduct(item.getProductId());

            CartItemResponse cartItemResponse = new CartItemResponse();
            cartItemResponse.setId(item.getId());
            cartItemResponse.setProductId(item.getProductId());
            cartItemResponse.setQuantity(item.getQuantity());
            cartItemResponse.setUnitPrice(product.getPrice());

            cartItemsResponse.add(cartItemResponse);

            BigDecimal itemUnitPrice = product.getPrice();
            BigDecimal itemTotalPrice = itemUnitPrice.multiply(BigDecimal.valueOf(item.getQuantity()));

            totalPrice = totalPrice.add(itemTotalPrice);
            totalQuantity += item.getQuantity();

        }

        cartResponse.setItems(cartItemsResponse);
        cartResponse.setTotalPrice(totalPrice);
        cartResponse.setTotalQuantity(totalQuantity);

        return cartResponse;
    }

}
