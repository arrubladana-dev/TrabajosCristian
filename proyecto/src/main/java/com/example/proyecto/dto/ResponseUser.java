package com.example.proyecto.dto;

import lombok.Data;

@Data
public class ResponseUser {
    /**
     * Nombre del usuario
     */
    private String name;

    /**
     * Apellido del usuario
     */
    private String lastName;

    /**
     * Edad del usuario
     */
    private Long age;


    /**
     * sexo
     */
    private String sex;

    /**
     * correo
     */
    private String email;
}
