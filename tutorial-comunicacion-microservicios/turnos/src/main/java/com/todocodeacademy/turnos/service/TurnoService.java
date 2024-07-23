package com.todocodeacademy.turnos.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.todocodeacademy.turnos.dto.TurnoDto;
import com.todocodeacademy.turnos.model.Paciente;
import com.todocodeacademy.turnos.model.Turno;
import com.todocodeacademy.turnos.repository.TurnoRepository;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private RestTemplate apiConsumir;

    @Override
    public List<Turno> getTurnos() {
        return turnoRepository.findAll();
    }

    @Override
    public Turno saveTurno(TurnoDto turnoDto) {

        Paciente paciente = apiConsumir
                .getForObject("http://localhost:9001/pacientes/get/dni/" + turnoDto.getDniPaciente(), Paciente.class);
        String nombreCompletoPaciente = paciente.getNombre() + " " + paciente.getApellido();
        Turno turnoNuevo = new Turno();
        turnoNuevo.setFecha(turnoDto.getFecha());
        turnoNuevo.setTratamiento(turnoDto.getTratamiento());
        turnoNuevo.setNombreCompletoPaciente(nombreCompletoPaciente);
        return turnoRepository.save(turnoNuevo);
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Turno findTurno(Long id) {
        return turnoRepository.findById(id).orElse(null);
    }

    @Override
    public Turno editTurno(Long id, Turno editTurno) {
        if (this.findTurno(id) == null) {
            return null;
        }
        editTurno.setId(id);
        return turnoRepository.save(editTurno);
    }

}
