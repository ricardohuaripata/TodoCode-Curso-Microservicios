package com.todocodeacademy.turnos.service;

import java.util.List;

import com.todocodeacademy.turnos.dto.TurnoDto;
import com.todocodeacademy.turnos.model.Turno;

public interface ITurnoService {

    public List<Turno> getTurnos();

    public Turno saveTurno(TurnoDto turnoDto);

    public void deleteTurno(Long id);

    public Turno findTurno(Long id);

    public Turno editTurno(Long id, Turno turno);

}
