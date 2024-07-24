package com.todocodeacademy.ingredientes.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Plato {
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private String descripcion;
    private List<String> listaIngredientes;

}
