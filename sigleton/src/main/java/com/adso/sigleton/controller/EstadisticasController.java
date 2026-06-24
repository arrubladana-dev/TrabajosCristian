package com.adso.sigleton.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adso.sigleton.service.EstadisticasService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/estadisticas")
@RequiredArgsConstructor
public class EstadisticasController {
    private final EstadisticasService estadisticas;


    @GetMapping
    public Map<String, Integer> total() {
        Map<String, Integer> resumen = new HashMap<>();
        resumen.put("totalAprendices", estadisticas.obtenerTotalAprendices());
        resumen.put("totalInstructores", estadisticas.obtenerTotalInstructores());
        resumen.put("totalProgramas", estadisticas.obtenerTotalProgramas());
        resumen.put("totalConsultas", estadisticas.obtenerTotalConsultas());
        return resumen;
    }
}
