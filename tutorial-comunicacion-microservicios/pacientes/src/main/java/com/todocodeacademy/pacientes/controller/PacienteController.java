package com.todocodeacademy.pacientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.todocodeacademy.pacientes.model.Paciente;
import com.todocodeacademy.pacientes.service.IPacienteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    @PostMapping("/create")
    public Paciente crearPaciente(@RequestBody Paciente paciente) {
        return pacienteService.savePaciente(paciente);
    }

    @GetMapping("/get")
    public List<Paciente> obtenerPacientes() {
        return pacienteService.getPacientes();
    }

    @DeleteMapping("/delete/{id}")
    public String borrarPaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
        return "Paciente eliminado correctamente";
    }

    @PutMapping("/update/{id}")
    public Paciente editarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        return pacienteService.editPaciente(id, paciente);
    }

    @GetMapping("/get/{id}")
    public Paciente obtenerPaciente(@PathVariable Long id) {
        return pacienteService.findPaciente(id);
    }

    @GetMapping("/get/dni/{dni}")
    public Paciente obtenerPacientePorDni(@PathVariable String dni) {
        return pacienteService.findPacienteByDni(dni);
    }

}
