package com.examen.veterinaria.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.veterinaria.dao.HttpGloblaResponseDTO;
import com.examen.veterinaria.dao.MessageResposeDTO;
import com.examen.veterinaria.dao.PetCreateUserDTO;
import com.examen.veterinaria.dao.PetList;
import com.examen.veterinaria.dao.PetResponse;
import com.examen.veterinaria.entity.Mascotas;
import com.examen.veterinaria.service.MacotaService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController              
@RequestMapping("/Mascotas")    
@RequiredArgsConstructor      
public class MascotaController {
    
    private final MacotaService masMacotaService;

    @PostMapping("create")
    public MessageResposeDTO createPet(@RequestBody PetCreateUserDTO petResponse){

        return masMacotaService.createPet(petResponse);

    }

    @GetMapping("get-pet")
    public List<PetList> listPet() {
        return masMacotaService.listPet();
    }
    

    @PutMapping("search-pet/{id}")
    public HttpGloblaResponseDTO<PetResponse> searchPet(@PathVariable Long id) {
        return masMacotaService.searchPet(id);
    }

    @DeleteMapping("delit-pet/{id}")
    public MessageResposeDTO deletePet(@PathVariable Long id){
        return masMacotaService.deletePet(id);
    }
}
