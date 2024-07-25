package com.todocodeacademy.envios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todocodeacademy.envios.model.Envio;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {
    List<Envio> findByDestinatario(Long destinatario);
}
