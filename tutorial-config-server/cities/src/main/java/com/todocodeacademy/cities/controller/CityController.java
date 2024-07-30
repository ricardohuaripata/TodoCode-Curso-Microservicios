package com.todocodeacademy.cities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todocodeacademy.cities.dto.CityDto;
import com.todocodeacademy.cities.service.CityService;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping()
    public CityDto getCity(@RequestParam String name, @RequestParam String country) {
        return cityService.getCity(name, country);
    }
}
