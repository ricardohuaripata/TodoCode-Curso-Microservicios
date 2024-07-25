package com.todocodeacademy.envios.service;

import java.util.List;

import com.todocodeacademy.envios.model.Envio;

public interface IEnvioService {
    public List<Envio> obtenerEnvios();

    public List<Envio> obtenerEnviosPorDestinatario(Long id);

    public Envio crearEnvio(Envio envio);

}
