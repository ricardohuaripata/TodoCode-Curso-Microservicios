package com.todocodeacademy.destinatarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todocodeacademy.destinatarios.model.Destinatario;
import com.todocodeacademy.destinatarios.response.DestinatarioResponse;
import com.todocodeacademy.destinatarios.service.IDestinatarioService;

@RestController
@RequestMapping("/destinatarios")
public class DestinatarioController {

    @Autowired
    private IDestinatarioService destinatarioService;

    @GetMapping()
    public List<Destinatario> getDestinatarios() {
        return destinatarioService.obtenerDestinatarios();
    }

    @GetMapping("/{id}")
    public DestinatarioResponse getDestinatarioById(@PathVariable Long id) {
        return destinatarioService.obtenerDestinatarioPorId(id);
    }

    @PostMapping()
    public Destinatario createDestinatario(@RequestBody Destinatario destinatario) {
        return destinatarioService.crearDestinatario(destinatario);
    }

}
