package com.todocodeacademy.envios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.envios.model.Envio;
import com.todocodeacademy.envios.repository.EnvioRepository;

@Service
public class EnvioService implements IEnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    @Override
    public List<Envio> obtenerEnvios() {
        return envioRepository.findAll();
    }

    @Override
    public Envio crearEnvio(Envio envio) {
        return envioRepository.save(envio);
    }

    @Override
    public List<Envio> obtenerEnviosPorDestinatario(Long id) {
        return envioRepository.findByDestinatario(id);
    }

}
