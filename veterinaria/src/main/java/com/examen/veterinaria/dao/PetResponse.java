package com.examen.veterinaria.dao;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PetResponse {
    

    private String name;

    private String race;

    private String nameOew;
}
