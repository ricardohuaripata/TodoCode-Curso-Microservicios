package com.todocodeacademy.destinatarios.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Envio {

    private Long id;
    private LocalDate fechaCreacion;
    private String estado;
    private String descripcion;
    private Long destinatario;

}
