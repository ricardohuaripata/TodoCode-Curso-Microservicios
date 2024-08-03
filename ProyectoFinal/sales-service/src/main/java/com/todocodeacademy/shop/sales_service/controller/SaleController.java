package com.todocodeacademy.shop.sales_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todocodeacademy.shop.sales_service.dto.SaleDto;
import com.todocodeacademy.shop.sales_service.dto.UpdateSaleDto;
import com.todocodeacademy.shop.sales_service.service.ISaleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private ISaleService saleService;

    @GetMapping()
    public ResponseEntity<?> getAllSales() {
        return new ResponseEntity<>(saleService.findAllSales(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSale(@PathVariable Long id) {
        return new ResponseEntity<>(saleService.findSale(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createSale(@RequestBody @Valid SaleDto saleDto) {
        return new ResponseEntity<>(saleService.createSale(saleDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSale(@PathVariable Long id, @RequestBody @Valid UpdateSaleDto updateSaleDto) {
        return new ResponseEntity<>(saleService.updateSale(id, updateSaleDto), HttpStatus.OK);
    }
}
