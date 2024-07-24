package com.todocodeacademy.platos.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 64, nullable = false, unique = true)
    private String nombre;
    private BigDecimal precio;
    private String descripcion;
    @ElementCollection
    @Column(name = "ingrediente")
    private List<String> listaIngredientes;
}
