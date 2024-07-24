package com.todocodeacademy.pokeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todocodeacademy.pokeapi.dto.PokemonDto;
import com.todocodeacademy.pokeapi.dto.ResultDto;
import com.todocodeacademy.pokeapi.repository.PokeAPIClient;

@RestController
public class PokemonController {
    @Autowired
    private PokeAPIClient pokeAPIClient;

    @GetMapping("/pokemon/{pokemonReference}")
    public PokemonDto getPokemonInfo(@PathVariable("pokemonReference") String variable) {
        return pokeAPIClient.getPokemonInfo(variable);
    }

    @GetMapping("/pokemon")
    public ResultDto getPokemonList(@RequestParam(name="limit") int limit, @RequestParam(name="offset") int offset) {
        return pokeAPIClient.getPokemonList(limit, offset);
    }

}
