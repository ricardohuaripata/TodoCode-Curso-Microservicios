package com.todocodeacademy.pacientes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.pacientes.model.Paciente;
import com.todocodeacademy.pacientes.repository.PacienteRepository;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> getPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente savePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);

    }

    @Override
    public Paciente findPaciente(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @Override
    public Paciente findPacienteByDni(String dni) {
        return pacienteRepository.findByDni(dni).orElse(null);
    }

    @Override
    public Paciente editPaciente(Long id, Paciente editPaciente) {
        if (this.findPaciente(id) == null) {
            return null;
        }
        editPaciente.setId(id);
        return pacienteRepository.save(editPaciente);
    }

}
