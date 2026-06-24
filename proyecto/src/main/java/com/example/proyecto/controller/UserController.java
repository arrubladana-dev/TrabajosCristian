package com.example.proyecto.controller;

import com.example.proyecto.dto.RegisterRequestDTO;
import com.example.proyecto.dto.ResponseListUserDTO;

import com.example.proyecto.service.UserServica;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;





@Controller
@RequiredArgsConstructor
public class UserController {
    
    private final UserServica userServica;

    @PostMapping("/create")
    public String createUser(@ModelAttribute("usuarioRegistro") RegisterRequestDTO requestDTO) {
        userServica.createUser(requestDTO);
        
        return "redirect:/get-user";
    }
    @GetMapping("/showNewUsuario")
    public String paginaNuevoUsuario(Model model) {
        
        model.addAttribute("usuarioRegistro", new RegisterRequestDTO());
        return "saveUsuario";
    }

    @GetMapping("/get-user")
    public String getUserDTO(Model model) {
        List<ResponseListUserDTO> responselistUsers = userServica.getUserDTOs();
        
        model.addAttribute("listaUsuarios", responselistUsers);
        return "listaUsuario";
    }


    
}
