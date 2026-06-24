package com.adso.sigleton.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adso.sigleton.service.EstadisticasService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/instructores")
@RequiredArgsConstructor
public class InstructorController {
    
    private final EstadisticasService estadisticas;

    @GetMapping
    public String listarInstructores() {
        estadisticas.incrementarInstructores();
        return "listado de instructores";
    }
}
