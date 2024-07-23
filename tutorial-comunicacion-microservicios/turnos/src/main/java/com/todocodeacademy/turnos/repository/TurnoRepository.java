package com.todocodeacademy.turnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todocodeacademy.turnos.model.Turno;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {
    
}
