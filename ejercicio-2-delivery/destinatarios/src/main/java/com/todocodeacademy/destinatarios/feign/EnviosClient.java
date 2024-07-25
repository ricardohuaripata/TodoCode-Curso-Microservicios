package com.todocodeacademy.destinatarios.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.todocodeacademy.destinatarios.model.Envio;

@FeignClient(name = "envios", url = "http://localhost:9001/envios")
public interface EnviosClient {

    @GetMapping("/destinatario/{destinatarioId}")
    public List<Envio> getEnviosByDestinatario(@PathVariable Long destinatarioId);

}
