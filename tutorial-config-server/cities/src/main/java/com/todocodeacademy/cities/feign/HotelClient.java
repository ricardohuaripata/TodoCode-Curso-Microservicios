package com.todocodeacademy.cities.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.todocodeacademy.cities.model.Hotel;

@FeignClient(name = "hotels-service", path = "/hotels")
public interface HotelClient {
    @GetMapping("/city/{cityId}")
    public List<Hotel> getHotelsByCity(@PathVariable Long cityId);

}
