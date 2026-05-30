package com.examen.veterinaria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.examen.veterinaria.dao.HttpGloblaResponseDTO;
import com.examen.veterinaria.dao.MessageResposeDTO;
import com.examen.veterinaria.dao.PetCreateUserDTO;
import com.examen.veterinaria.dao.PetList;
import com.examen.veterinaria.dao.PetResponse;
import com.examen.veterinaria.entity.Mascotas;
import com.examen.veterinaria.repository.MascotaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MacotaService {
    
    private final MascotaRepository mascotaRepository;

    public MessageResposeDTO createPet(PetCreateUserDTO petResponse) {
        Mascotas mascotas = new Mascotas();

        mascotas.setName(petResponse.getName());
        mascotas.setRace(petResponse.getRace());
        mascotas.setNameOew(petResponse.getNameOew());
        mascotas.setPassaword(petResponse.getPassaword());
        mascotas.setEmailOew(petResponse.getEmailOew());
        mascotaRepository.save(mascotas);

        MessageResposeDTO response = new MessageResposeDTO();

        response.setMessage("Se añadio una nueva mascota");

        return response;

    }

    public List<PetList> listPet() {
        List<PetList> petList = new ArrayList<>();
        List<Mascotas> petFount = mascotaRepository.findAll();

        for (Mascotas mascotas : petFount) {
            PetList pet = new PetList();
            pet.setName(mascotas.getName());
            pet.setNameOew(mascotas.getNameOew());
            petList.add(pet);
        }
        
        return petList;
    }

    public HttpGloblaResponseDTO<PetResponse> searchPet(Long id){
        HttpGloblaResponseDTO<PetResponse> response = new HttpGloblaResponseDTO<>();

        Optional<Mascotas> petSerh = mascotaRepository.findById(id);

        if (petSerh==null){
            response.setMessage("No existe esa mascota");
            return response;
        }

        Mascotas petFount = petSerh.get();
        
        PetResponse petFinal = new PetResponse();

        petFinal.setName(petFount.getName());
        petFinal.setRace(petFount.getRace());
        petFinal.setNameOew(petFount.getNameOew());

        response.setData(petFinal);
        response.setMessage("Se encontro su mascota: ");

        return response;
    }

    public MessageResposeDTO deletePet(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePet'");
    }


}
