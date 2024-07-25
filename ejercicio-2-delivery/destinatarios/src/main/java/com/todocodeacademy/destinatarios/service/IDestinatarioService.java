package com.todocodeacademy.destinatarios.service;

import java.util.List;

import com.todocodeacademy.destinatarios.model.Destinatario;
import com.todocodeacademy.destinatarios.response.DestinatarioResponse;

public interface IDestinatarioService {
    public Destinatario crearDestinatario(Destinatario destinatario);

    public List<Destinatario> obtenerDestinatarios();

    public DestinatarioResponse obtenerDestinatarioPorId(Long id);

}
