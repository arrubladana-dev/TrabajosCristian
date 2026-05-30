package com.examen.veterinaria.dao;

import lombok.Data;

@Data
public class HttpGloblaResponseDTO<T> {
    private T data;
    private String message;
}
