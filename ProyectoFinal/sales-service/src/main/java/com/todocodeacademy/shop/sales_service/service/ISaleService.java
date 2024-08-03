package com.todocodeacademy.shop.sales_service.service;

import java.util.List;

import com.todocodeacademy.shop.sales_service.dto.SaleDto;
import com.todocodeacademy.shop.sales_service.dto.UpdateSaleDto;
import com.todocodeacademy.shop.sales_service.model.Sale;

public interface ISaleService {
    public Sale findSale(Long id);

    public List<Sale> findAllSales();

    public Sale createSale(SaleDto saleDto);

    public Sale updateSale(Long id, UpdateSaleDto updateSaleDto);

}
