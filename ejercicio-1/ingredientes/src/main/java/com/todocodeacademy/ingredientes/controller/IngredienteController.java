package com.todocodeacademy.ingredientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todocodeacademy.ingredientes.model.Ingrediente;
import com.todocodeacademy.ingredientes.service.IIngredienteService;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {

    @Autowired
    private IIngredienteService ingredienteService;

    @PostMapping("/create")
    public Ingrediente crearIngrediente(@RequestBody Ingrediente ingrediente) {
        return ingredienteService.saveIngrediente(ingrediente);
    }

    @GetMapping("/get")
    public List<Ingrediente> obtenerIngredientes() {
        return ingredienteService.getIngredientes();
    }

    @GetMapping("/get/plato/{nombrePlato}")
    public List<Ingrediente> obtenerIngredientesPorPlato(@PathVariable String nombrePlato) {
        return ingredienteService.getIngredientesByPlato(nombrePlato);
    }
}
