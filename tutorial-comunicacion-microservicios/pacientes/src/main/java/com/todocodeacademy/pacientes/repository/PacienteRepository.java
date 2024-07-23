package com.todocodeacademy.pacientes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todocodeacademy.pacientes.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    //@Query("SELECT p FROM Paciente p Where p.dni = :dni")
    Optional<Paciente> findByDni(String dni);

}
