package com.example.proyecto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyecto.dto.HttpGlobalResponse;
import com.example.proyecto.dto.MessageResponse;
import com.example.proyecto.dto.RegisterRequestDTO;
import com.example.proyecto.dto.ResponseListUserDTO;
import com.example.proyecto.dto.ResponseUser;
import com.example.proyecto.entity.User;
import com.example.proyecto.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServica {
    
    private final UserRepository userRepository;

    public MessageResponse createUser(RegisterRequestDTO requestDTO){

        MessageResponse response = new MessageResponse();

        response.setMessage("Usuario Creado wii");

        User user = new User();
        user.setNombre(requestDTO.getName());
        user.setApellidos(requestDTO.getLastName());
        user.setEdad(requestDTO.getAge());
        user.setSexo(requestDTO.getSex());
        user.setCorreo(requestDTO.getEmail());
        userRepository.save(user);
        return response;
    }

    public List<ResponseListUserDTO> getUserDTOs(){
        List<ResponseListUserDTO> userFount = new ArrayList<>();
        List<User> userNew = userRepository.findAll();

        for (User user : userNew) {
            ResponseListUserDTO u = new ResponseListUserDTO();
            u.setId(user.getId());
            u.setName(user.getNombre());
            u.setLastName(user.getApellidos());
            u.setAge(user.getEdad());
            u.setEmail(user.getCorreo());
            u.setSex(user.getSexo());
            userFount.add(u);
        }

        return userFount;
    }

    public HttpGlobalResponse<ResponseUser> serchUser(Long id){
        HttpGlobalResponse<ResponseUser> userFount = new HttpGlobalResponse<>();

        Optional<User> userNwe = userRepository.findById(id);
        
        if (userNwe.isEmpty()) {
            userFount.setMessage("Usuario no encontrado");
            return userFount;
        }

        User userFinal = userNwe.get();

        ResponseUser userResponse = new ResponseUser();

        userResponse.setName(userFinal.getNombre());
        userResponse.setLastName(userFinal.getApellidos());
        userResponse.setAge(userFinal.getEdad());
        userResponse.setSex(userFinal.getSexo());
        userResponse.setEmail(userFinal.getCorreo());
        
        userFount.setMessage("Usuario encontrado");
        userFount.setData(userResponse);
        return userFount;
    }

    public MessageResponse deleteUser(Long id) {
        MessageResponse response = new MessageResponse();
        Optional<User> userNwe = userRepository.findById(id);
        
        if (userNwe.isEmpty()) {
            response.setMessage("Usno encontrado");
            return response;
        }

        userRepository.deleteById(id);
        response.setMessage(" encontrado");
            return response;
    }

    public MessageResponse putUser(Long id, ResponseUser usResponseUser) {
        MessageResponse response = new MessageResponse();
        Optional<User> userNwe = userRepository.findById(id);
        
        if (userNwe.isEmpty()) {
            response.setMessage("Usno encontrado");
            return response;
        }

        User userFinal = userNwe.get();

        userFinal.setNombre(usResponseUser.getName());
        userFinal.setApellidos(usResponseUser.getLastName());
        userFinal.setEdad(usResponseUser.getAge());
        userFinal.setSexo(usResponseUser.getSex());
        userFinal.setCorreo(usResponseUser.getEmail());

        userRepository.save(userFinal);

        response.setMessage("Ususrio actiualizado");


        return response;
    }

}
