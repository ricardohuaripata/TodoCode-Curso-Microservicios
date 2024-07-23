package com.todocodeacademy.pacientes.service;

import java.util.List;

import com.todocodeacademy.pacientes.model.Paciente;

public interface IPacienteService {

    public List<Paciente> getPacientes();

    public Paciente savePaciente(Paciente paciente);

    public void deletePaciente(Long id);

    public Paciente findPaciente(Long id);

    public Paciente findPacienteByDni(String dni);

    public Paciente editPaciente(Long id, Paciente paciente);

}
