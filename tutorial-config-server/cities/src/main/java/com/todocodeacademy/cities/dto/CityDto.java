package com.todocodeacademy.cities.dto;

import java.util.List;

import com.todocodeacademy.cities.model.Hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityDto {
    private Long id;
    private String name;
    private String continent;
    private String country;
    private String state;
    private List<Hotel> hotels;

}
