package com.examen.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.veterinaria.entity.Mascotas;

@Repository
public interface MascotaRepository extends JpaRepository<Mascotas, Long > {

    
} 