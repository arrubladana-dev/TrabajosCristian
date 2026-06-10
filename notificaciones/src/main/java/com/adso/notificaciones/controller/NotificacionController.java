package com.adso.notificaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adso.notificaciones.service.NotificacionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {
    
    @Autowired
    private NotificacionService nService;

    @GetMapping("/{tipo}")
    public String enviar(@PathVariable String tipo) {
        return nService.generarReporte(tipo);
    }
    
}
