package com.todocodeacademy.cities.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.cities.dto.CityDto;
import com.todocodeacademy.cities.feign.HotelClient;
import com.todocodeacademy.cities.model.City;
import com.todocodeacademy.cities.model.Hotel;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class CityService {

    @Autowired
    private HotelClient hotelClient;

    List<City> cities = new ArrayList<City>();

    @CircuitBreaker(name = "hotels-service", fallbackMethod = "fallbackGetCity")
    @Retry(name = "hotels-service")
    public CityDto getCity(String name, String country) {

        City city = findCity(name, country);

        List<Hotel> hotels = hotelClient.getHotelsByCity(city.getId());

        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setName(city.getName());
        cityDto.setCountry(city.getCountry());
        cityDto.setContinent(city.getContinent());
        cityDto.setState(city.getState());
        cityDto.setHotels(hotels);

        //createException();

        return cityDto;
    }

    public CityDto fallbackGetCity(Throwable throwable) {
        return new CityDto(null, null, null, null, null, null);

    }

    public City findCity(String name, String country) {
        this.loadCities();
        for (City c : cities) {
            if (c.getName().equals(name)) {
                if (c.getCountry().equals(country)) {
                    return c;
                }

            }

        }
        return null;
    }

    public void loadCities() {

        cities.add(new City(1L, "Buenos Aires", "South America", "Argentina", "Buenos Aires"));
        cities.add(new City(2L, "Oberá", "South America", "Argentina", "Misiones"));
        cities.add(new City(3L, "Mexico City", "North America", "Mexico", "Mexico City"));
        cities.add(new City(4L, "Guadalajara", "North America", "Mexico", "Jalisco"));
        cities.add(new City(5L, "Bogotá", "South America", "Colombia", "Cundinamarca"));
        cities.add(new City(6L, "Medellín", "South America", "Colombia", "Antioquia"));
        cities.add(new City(7L, "Santiago", "South America", "Chile", "Santiago Metropolitan"));
        cities.add(new City(8L, "Valparaíso", "South America", "Chile", "Valparaíso"));
        cities.add(new City(9L, "Asunción", "South America", "Paraguay", "Asunción"));
        cities.add(new City(10L, "Montevideo", "South America", "Uruguay", "Montevideo"));
        cities.add(new City(11L, "Madrid", "Europe", "Spain", "Community of Madrid"));
        cities.add(new City(12L, "Barcelona", "Europe", "Spain", "Catalonia"));
        cities.add(new City(13L, "Seville", "Europe", "Spain", "Andalucia"));
        cities.add(new City(14L, "Monterrey", "North America", "Mexico", "Nuevo León"));
        cities.add(new City(15L, "Valencia", "Europe", "Spain", "Valencian Community"));

    }

    public void createException() {
        throw new IllegalArgumentException("Prueba Resilience y Circuit Breaker");

    }
}
