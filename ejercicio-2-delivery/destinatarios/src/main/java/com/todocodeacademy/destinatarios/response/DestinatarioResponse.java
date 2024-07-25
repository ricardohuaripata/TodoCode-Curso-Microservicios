package com.todocodeacademy.destinatarios.response;

import java.util.List;

import com.todocodeacademy.destinatarios.model.Envio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DestinatarioResponse {
    private Long id;
    private String dni;
    private String nombre;
    private String apellido;
    private String numTelefono;
    private List<Envio> envios;
}
