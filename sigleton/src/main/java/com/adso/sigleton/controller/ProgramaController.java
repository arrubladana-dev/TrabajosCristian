package com.adso.sigleton.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adso.sigleton.service.EstadisticasService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/programas")
@RequiredArgsConstructor
public class ProgramaController {
    
    private final EstadisticasService estadisticas;

    @GetMapping
    public String listarProgramas() {
        estadisticas.incrementarProgramas();
        return "listado de programas de formacion";
    }
}
