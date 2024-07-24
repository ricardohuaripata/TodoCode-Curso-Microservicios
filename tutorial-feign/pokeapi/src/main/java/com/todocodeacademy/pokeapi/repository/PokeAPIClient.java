package com.todocodeacademy.pokeapi.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.todocodeacademy.pokeapi.dto.PokemonDto;
import com.todocodeacademy.pokeapi.dto.ResultDto;

@FeignClient(name = "pokeapi", url = "https://pokeapi.co/api/v2")
public interface PokeAPIClient {
    @GetMapping("/pokemon/{pokemonReference}")
    public PokemonDto getPokemonInfo(@PathVariable("pokemonReference") String variable);

    @GetMapping("/pokemon")
    public ResultDto getPokemonList(@RequestParam(name="limit") int limit, @RequestParam(name="offset") int offset);
}
