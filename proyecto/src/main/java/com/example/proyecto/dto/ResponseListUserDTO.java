package com.example.proyecto.dto;
import lombok.Data;

@Data
public class ResponseListUserDTO {
    /**
     * Nombre del usuario
     */
    private Long id;
    
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