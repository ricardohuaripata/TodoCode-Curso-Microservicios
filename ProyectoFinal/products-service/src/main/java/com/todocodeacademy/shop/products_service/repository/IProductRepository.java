package com.todocodeacademy.shop.products_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todocodeacademy.shop.products_service.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    
}
