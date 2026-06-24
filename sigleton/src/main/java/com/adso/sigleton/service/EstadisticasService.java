package com.adso.sigleton.service;

import org.springframework.stereotype.Service;

@Service
public class EstadisticasService {
    
    private int totalAprendices;
    private int totalInstructores;
    private int totalProgramas;


    public void incrementarAprendices() {
        totalAprendices++;
    }

    public void incrementarInstructores() {
        totalInstructores++;
    }

    public void incrementarProgramas() {
        totalProgramas++;
    }

    public int obtenerTotalAprendices() {
        return totalAprendices;
    }

    public int obtenerTotalInstructores() {
        return totalInstructores;
    }

    public int obtenerTotalProgramas() {
        return totalProgramas;
    }

    public int obtenerTotalConsultas() {
        return totalAprendices + totalInstructores + totalProgramas;
    }
}
