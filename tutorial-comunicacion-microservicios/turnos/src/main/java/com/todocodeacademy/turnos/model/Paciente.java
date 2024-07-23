package com.todocodeacademy.turnos.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    private Long id;
    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;

}