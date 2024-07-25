package com.todocodeacademy.platos.service;

import java.util.List;

import com.todocodeacademy.platos.dto.PlatoDto;
import com.todocodeacademy.platos.model.Plato;

public interface IPlatoService {
    public List<Plato> getPlatos();
    public Plato savePlato(PlatoDto platoDto);

}
