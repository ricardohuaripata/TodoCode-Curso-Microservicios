package com.todocodeacademy.ingredientes.service;

import java.util.List;

import com.todocodeacademy.ingredientes.model.Ingrediente;

public interface IIngredienteService {
    public List<Ingrediente> getIngredientes();

    public Ingrediente saveIngrediente(Ingrediente ingrediente);

    public List<Ingrediente> getIngredientesByPlato(String nombrePlato);
}
