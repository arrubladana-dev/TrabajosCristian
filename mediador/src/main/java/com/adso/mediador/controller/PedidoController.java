package com.adso.mediador.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adso.mediador.dto.MensajeDto;
import com.adso.mediador.mediado.MediadorPedidos;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final MediadorPedidos mediadorPedidos;


    @PostMapping("/mensaje")
    public String enviarMensaje(@RequestBody MensajeDto mensajeDto) {

        return mediadorPedidos.enviarMensaje(
                mensajeDTO.getRemitente(),
                mensajeDTO.getMensaje()
        );
    }
}