package com.example.demo.controllers;

import com.example.demo.entities.Usuario;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    RoleRepository roleRepo;

    @Autowired
    UsuarioService usuarioService;
    
    //Hacer gets para mapear el index y el user-form
    @GetMapping("/")
    public String index(){
        return "index";
    }

    //http://localhost:8080//userForm
    @GetMapping("/userForm")
    public String userForm(Model model){
        //model.addAttribute("userForm", new Usuario());
        //model.addAttribute("roles",  roleRepo.findAll());
        model.addAttribute("lista", usuarioService.getAllUsers()); //todos los usuarios
        //model.addAttribute("listTab", "active");
        return "user-form/user-view";
    }



    //esto es para probar la dataBase unicamente, el controller nunca deberia llamar al repo. BORRAR LUEGO.
    @GetMapping("/usuarios")
    public ResponseEntity<?> listarUsuarios() {

        return ResponseEntity.ok(usuarioRepo.findAll());
    }

}