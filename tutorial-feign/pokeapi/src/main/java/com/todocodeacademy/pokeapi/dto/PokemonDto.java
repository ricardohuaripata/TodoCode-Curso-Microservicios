package com.todocodeacademy.pokeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PokemonDto {
    private int id;
    private String name;
    private int weight;
    private int height;

}
