package com.adso.sigleton.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adso.sigleton.service.EstadisticasService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/aprendices")
@RequiredArgsConstructor
public class AprendizController {
    
    private final EstadisticasService estadisticas;


    @GetMapping()
    public String listarAprendices() {
        estadisticas.incrementarAprendices();
        return "listado de aprendices";
    }
}
