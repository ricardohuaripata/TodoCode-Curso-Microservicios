package com.todocodeacademy.turnos.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TurnoDto {

    private LocalDate fecha;
    private String tratamiento;
    private String dniPaciente;

}
