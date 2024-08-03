package com.todocodeacademy.shop.sales_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todocodeacademy.shop.sales_service.model.Sale;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Long> {

}
