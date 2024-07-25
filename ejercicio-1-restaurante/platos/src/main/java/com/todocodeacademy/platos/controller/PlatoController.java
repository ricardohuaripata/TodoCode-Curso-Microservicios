package com.todocodeacademy.platos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todocodeacademy.platos.dto.PlatoDto;
import com.todocodeacademy.platos.model.Plato;
import com.todocodeacademy.platos.service.IPlatoService;

@RestController
@RequestMapping("/platos")
public class PlatoController {
    @Autowired
    private IPlatoService platoService;

    @PostMapping("/create")
    public Plato crearPlato(@RequestBody PlatoDto platoDto) {
        return platoService.savePlato(platoDto);
    }

    @GetMapping("/get")
    public List<Plato> obtenerPlatos() {
        return platoService.getPlatos();
    }

}
