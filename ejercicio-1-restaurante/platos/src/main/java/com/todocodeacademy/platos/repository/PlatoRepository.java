package com.todocodeacademy.platos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todocodeacademy.platos.model.Plato;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Long> {

}
