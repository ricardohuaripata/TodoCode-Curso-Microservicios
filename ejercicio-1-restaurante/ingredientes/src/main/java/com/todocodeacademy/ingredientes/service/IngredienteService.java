package com.todocodeacademy.ingredientes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.ingredientes.model.Ingrediente;
import com.todocodeacademy.ingredientes.repository.IngredienteRepository;

@Service
public class IngredienteService implements IIngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Override
    public List<Ingrediente> getIngredientes() {
        return ingredienteRepository.findAll();
    }

    @Override
    public Ingrediente saveIngrediente(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    @Override
    public List<Ingrediente> getIngredientesByPlato(String nombrePlato) {
        return ingredienteRepository.findIngredientesByPlato(nombrePlato);
    }

}
