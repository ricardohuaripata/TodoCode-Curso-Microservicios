package com.todocodeacademy.shop.products_service.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.shop.products_service.dto.ProductDto;
import com.todocodeacademy.shop.products_service.exceptions.ProductNotFoundException;
import com.todocodeacademy.shop.products_service.model.Product;
import com.todocodeacademy.shop.products_service.repository.IProductRepository;

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

}
