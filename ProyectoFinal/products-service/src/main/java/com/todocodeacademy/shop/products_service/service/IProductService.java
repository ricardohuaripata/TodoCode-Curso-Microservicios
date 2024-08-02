package com.todocodeacademy.shop.products_service.service;

import java.util.List;

import com.todocodeacademy.shop.products_service.dto.ProductDto;
import com.todocodeacademy.shop.products_service.model.Product;

public interface IProductService {
    public Product saveProduct(ProductDto productDto);

    public List<Product> findProducts();

    public Product findProduct(Long id);

    public Product updateProduct(Long id, ProductDto productDto);

    public void deleteProduct(Long id);

}
