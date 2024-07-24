package com.todocodeacademy.ingredientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todocodeacademy.ingredientes.model.Ingrediente;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
    @Query("SELECT i FROM Ingrediente i WHERE :plato MEMBER OF i.listaPlatos")
    List<Ingrediente> findIngredientesByPlato(String plato);
}
