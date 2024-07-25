package com.todocodeacademy.destinatarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todocodeacademy.destinatarios.model.Destinatario;

@Repository
public interface DestinatarioRepository extends JpaRepository<Destinatario, Long> {

}
