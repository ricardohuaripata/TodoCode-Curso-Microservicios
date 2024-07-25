package com.todocodeacademy.envios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todocodeacademy.envios.model.Envio;
import com.todocodeacademy.envios.service.IEnvioService;

@RestController
@RequestMapping("/envios")
public class EnvioController {
    @Autowired
    private IEnvioService envioService;

    @GetMapping()
    public List<Envio> getEnvios() {
        return envioService.obtenerEnvios();
    }

    @GetMapping("/destinatario/{destinatarioId}")
    public List<Envio> getEnviosByDestinatario(@PathVariable Long destinatarioId) {
        return envioService.obtenerEnviosPorDestinatario(destinatarioId);
    }

    @PostMapping()
    public Envio createEnvio(@RequestBody Envio envio) {
        return envioService.crearEnvio(envio);
    }

}
