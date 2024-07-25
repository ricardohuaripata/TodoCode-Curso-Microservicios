package com.todocodeacademy.platos.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingrediente {
    private Long id;
    private String nombre;
    private List<String> listaPlatos;

}
