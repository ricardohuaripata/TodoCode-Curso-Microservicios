package com.todocodeacademy.destinatarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.destinatarios.feign.EnviosClient;
import com.todocodeacademy.destinatarios.model.Destinatario;
import com.todocodeacademy.destinatarios.model.Envio;
import com.todocodeacademy.destinatarios.repository.DestinatarioRepository;
import com.todocodeacademy.destinatarios.response.DestinatarioResponse;

@Service
public class DestinatarioService implements IDestinatarioService {

    @Autowired
    private DestinatarioRepository destinatarioRepository;

    @Autowired
    private EnviosClient enviosClient;

    @Override
    public Destinatario crearDestinatario(Destinatario destinatario) {
        return destinatarioRepository.save(destinatario);
    }

    @Override
    public List<Destinatario> obtenerDestinatarios() {
        return destinatarioRepository.findAll();
    }

    @Override
    public DestinatarioResponse obtenerDestinatarioPorId(Long id) {
        Destinatario targetDestinatario = destinatarioRepository.findById(id).orElse(null);
        if (targetDestinatario == null) {
            return null;
        }
        List<Envio> envios = enviosClient.getEnviosByDestinatario(id);

        DestinatarioResponse destinatarioResponse = new DestinatarioResponse();
        destinatarioResponse.setId(targetDestinatario.getId());
        destinatarioResponse.setDni(targetDestinatario.getDni());
        destinatarioResponse.setNombre(targetDestinatario.getNombre());
        destinatarioResponse.setApellido(targetDestinatario.getApellido());
        destinatarioResponse.setNumTelefono(targetDestinatario.getNumTelefono());
        destinatarioResponse.setEnvios(envios);

        return destinatarioResponse;
    }

}
