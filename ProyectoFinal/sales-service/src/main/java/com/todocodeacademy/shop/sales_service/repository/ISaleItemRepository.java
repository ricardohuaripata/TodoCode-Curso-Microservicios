package com.todocodeacademy.shop.sales_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todocodeacademy.shop.sales_service.model.SaleItem;

@Repository
public interface ISaleItemRepository extends JpaRepository<SaleItem, Long> {

}
