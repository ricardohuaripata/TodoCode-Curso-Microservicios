package com.todocodeacademy.shop.sales_service.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todocodeacademy.shop.sales_service.dto.SaleDto;
import com.todocodeacademy.shop.sales_service.dto.UpdateSaleDto;
import com.todocodeacademy.shop.sales_service.exception.NoItemsToPayException;
import com.todocodeacademy.shop.sales_service.exception.SaleNotFoundException;
import com.todocodeacademy.shop.sales_service.feign.ICartsServiceClient;
import com.todocodeacademy.shop.sales_service.model.Sale;
import com.todocodeacademy.shop.sales_service.model.SaleItem;
import com.todocodeacademy.shop.sales_service.repository.ISaleItemRepository;
import com.todocodeacademy.shop.sales_service.repository.ISaleRepository;
import com.todocodeacademy.shop.sales_service.response.CartItemResponse;
import com.todocodeacademy.shop.sales_service.response.CartResponse;

@Service
public class SaleService implements ISaleService {

    @Autowired
    private ISaleRepository saleRepository;

    @Autowired
    private ISaleItemRepository saleItemRepository;

    @Autowired
    private ICartsServiceClient cartsServiceClient;

    @Override
    public Sale findSale(Long id) {
        return saleRepository.findById(id).orElseThrow(SaleNotFoundException::new);
    }

    @Override
    public List<Sale> findAllSales() {
        return saleRepository.findAll();
    }

    @Override
    @Transactional // Operacion transaccional
    public Sale createSale(SaleDto saleDto) {
        CartResponse cartResponse = cartsServiceClient.getCart(saleDto.getCartId());

        // Si el carrito NO contiene articulos que pagar
        if (cartResponse.getItems() == null || cartResponse.getItems().isEmpty()) {
            throw new NoItemsToPayException();
        }
        // Si el carrito SI contiene articulos que pagar
        Sale newSale = new Sale();
        newSale.setFirstName(saleDto.getFirstName());
        newSale.setLastName(saleDto.getLastName());
        newSale.setCountry(saleDto.getCountry());
        newSale.setCity(saleDto.getCity());
        newSale.setPostalCode(saleDto.getPostalCode());
        newSale.setAddressLine1(saleDto.getAddressLine1());
        newSale.setAddressLine2(saleDto.getAddressLine2());
        newSale.setContactEmail(saleDto.getContactEmail());
        newSale.setContactPhone(saleDto.getContactPhone());
        Date currentDate = new Date();
        newSale.setCreatedAt(currentDate);
        newSale.setUpdatedAt(currentDate);

        Sale createdSale = saleRepository.save(newSale);

        List<SaleItem> saleItems = new ArrayList<SaleItem>();

        for (CartItemResponse itemResponse : cartResponse.getItems()) {

            SaleItem newSaleItem = new SaleItem();
            newSaleItem.setProductId(itemResponse.getProduct().getId());
            newSaleItem.setName(itemResponse.getProduct().getName());
            newSaleItem.setBrand(itemResponse.getProduct().getBrand());
            newSaleItem.setPrice(itemResponse.getProduct().getPrice());
            newSaleItem.setQuantity(itemResponse.getQuantity());
            newSaleItem.setSale(createdSale);

            SaleItem createdSaleItem = saleItemRepository.save(newSaleItem);
            saleItems.add(createdSaleItem);

        }

        createdSale.setItems(saleItems);
        cartsServiceClient.deleteCart(cartResponse.getId());
        return createdSale;
    }

    @Override
    public Sale updateSale(Long id, UpdateSaleDto updateSaleDto) {
        
        Sale sale = this.findSale(id);

        sale.setFirstName(updateSaleDto.getFirstName());
        sale.setLastName(updateSaleDto.getLastName());
        sale.setCountry(updateSaleDto.getCountry());
        sale.setCity(updateSaleDto.getCity());
        sale.setPostalCode(updateSaleDto.getPostalCode());
        sale.setAddressLine1(updateSaleDto.getAddressLine1());
        sale.setAddressLine2(updateSaleDto.getAddressLine2());
        sale.setContactEmail(updateSaleDto.getContactEmail());
        sale.setContactPhone(updateSaleDto.getContactPhone());
        sale.setUpdatedAt(new Date());
        return saleRepository.save(sale);
    }

}
