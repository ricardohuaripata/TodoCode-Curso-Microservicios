package com.todocodeacademy.shop.products_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.todocodeacademy.shop.products_service.dto.ProductDto;
import com.todocodeacademy.shop.products_service.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(productService.findProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        return new ResponseEntity<>(productService.findProduct(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody @Valid ProductDto productDto) {
        return new ResponseEntity<>(productService.saveProduct(productDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid ProductDto productDto) {
        return new ResponseEntity<>(productService.updateProduct(id, productDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Successfully deleted.", HttpStatus.OK);
    }

}
