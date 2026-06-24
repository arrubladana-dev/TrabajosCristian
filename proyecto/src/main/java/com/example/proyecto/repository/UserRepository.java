package com.example.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.proyecto.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
