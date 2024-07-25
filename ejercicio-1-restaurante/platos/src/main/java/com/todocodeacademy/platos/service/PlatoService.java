package com.todocodeacademy.platos.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.todocodeacademy.platos.dto.PlatoDto;
import com.todocodeacademy.platos.model.Ingrediente;
import com.todocodeacademy.platos.model.Plato;
import com.todocodeacademy.platos.repository.PlatoRepository;

@Service
public class PlatoService implements IPlatoService {

    @Autowired
    private PlatoRepository platoRepository;

    @Autowired
    private RestTemplate api;

    @Override
    public List<Plato> getPlatos() {
        return platoRepository.findAll();
    }

    @Override
    public Plato savePlato(PlatoDto platoDto) {

        Plato nuevoPlato = new Plato();
        nuevoPlato.setNombre(platoDto.getNombre());
        nuevoPlato.setPrecio(platoDto.getPrecio());
        nuevoPlato.setDescripcion(platoDto.getDescripcion());
        List<String> ingredientes = new ArrayList<String>();
        List<Ingrediente> listaIngredientes = Arrays.asList(api.getForObject(
                "http://localhost:9002/ingredientes/get/plato/" + platoDto.getNombre(), Ingrediente[].class));
        for (Ingrediente ingrediente : listaIngredientes) {
            ingredientes.add(ingrediente.getNombre());

        }
        nuevoPlato.setListaIngredientes(ingredientes);

        return platoRepository.save(nuevoPlato);
    }

}
