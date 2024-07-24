package com.todocodeacademy.pokeapi.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto {

    private int count;
    private List<PokemonResultDto> results;
    
}
