package com.todocodeacademy.hotels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todocodeacademy.hotels.model.Hotel;
import com.todocodeacademy.hotels.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/city/{cityId}")
    public List<Hotel> getHotelsByCity(@PathVariable Long cityId) {
        return hotelService.getHotelsByCity(cityId);

    }
}
