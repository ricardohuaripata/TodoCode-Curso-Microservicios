package com.todocodeacademy.turnos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todocodeacademy.turnos.dto.TurnoDto;
import com.todocodeacademy.turnos.model.Turno;
import com.todocodeacademy.turnos.service.ITurnoService;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private ITurnoService turnoService;

    @PostMapping("/create")
    public Turno crearTurno(@RequestBody TurnoDto turnoDto) {
        return turnoService.saveTurno(turnoDto);
    }

    @GetMapping("/get")
    public List<Turno> obtenerTurnos() {
        return turnoService.getTurnos();
    }

    @DeleteMapping("/delete/{id}")
    public String borrarTurno(@PathVariable Long id) {
        turnoService.deleteTurno(id);
        return "Turno eliminado correctamente";
    }

    @PutMapping("/update/{id}")
    public Turno editarTurno(@PathVariable Long id, @RequestBody Turno turno) {
        return turnoService.editTurno(id, turno);
    }

    @GetMapping("/get/{id}")
    public Turno obtenerTurno(@PathVariable Long id) {
        return turnoService.findTurno(id);
    }

}
