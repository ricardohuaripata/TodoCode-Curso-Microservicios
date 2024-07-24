package com.todocodeacademy.platos.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlatoDto {
    private String nombre;
    private BigDecimal precio;
    private String descripcion;

}
