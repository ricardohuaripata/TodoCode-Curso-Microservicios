package com.todocodeacademy.hotels.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.todocodeacademy.hotels.model.Hotel;

@Service
public class HotelService {

    List<Hotel> hotels = new ArrayList<Hotel>();

    public List<Hotel> getHotelsByCity(Long cityId) {

        List<Hotel> hotelCityList = new ArrayList<Hotel>();

        // carga la bd "lógica"
        this.loadHotels();
        // busca si coincide la id
        for (Hotel h : hotels) {
            if (h.getCityId() == cityId) {
                hotelCityList.add(h);
            }

        }
        return hotelCityList;
    }

    public void loadHotels() {

        hotels.add(new Hotel(1L, "Paradise", 5, 1L));
        hotels.add(new Hotel(2L, "Sunset View", 4, 2L));
        hotels.add(new Hotel(3L, "Ocean Breeze", 3, 3L));
        hotels.add(new Hotel(4L, "Mountain Retreat", 4, 1L));
        hotels.add(new Hotel(5L, "City Lights Inn", 3, 2L));
        hotels.add(new Hotel(6L, "Riverside Lodge", 4, 3L));
        hotels.add(new Hotel(7L, "Cozy Cabin Resort", 2, 1L));
        hotels.add(new Hotel(8L, "Luxury Haven", 5, 2L));
        hotels.add(new Hotel(9L, "Historic Grand Hotel", 4, 3L));
        hotels.add(new Hotel(10L, "Tranquil Gardens", 3, 1L));

    }
}
