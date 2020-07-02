package com.example.demo.controllers;

import javax.validation.Valid;

import com.example.demo.entities.Usuario;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("userForm", new Usuario());
        model.addAttribute("roles",  roleRepo.findAll());
        model.addAttribute("lista", usuarioService.getAllUsers()); //todos los usuarios
        model.addAttribute("listTab", "active");
        return "user-form/user-view";
    }



    //esto es para probar la dataBase unicamente, el controller nunca deberia llamar al repo. BORRAR LUEGO.
    @GetMapping("/usuarios")
    public ResponseEntity<?> listarUsuarios() {

        return ResponseEntity.ok(usuarioRepo.findAll());
    }

    //metodo para validacion
    @PostMapping("/userForm")
    public String crearUsuario(@Valid @ModelAttribute("userForm") Usuario usuario, BindingResult result, ModelMap model ){
        //verificar si el resultado tiene errores
        //si tiene errores mostrar la informacion otra vez, para eso paso el obj usuario
        if(result.hasErrors()){
            model.addAttribute("userForm", usuario);
            model.addAttribute("formTab", "active");

        }

        model.addAttribute("lista", usuarioService.getAllUsers()); //todos los usuarios
        model.addAttribute("roles",  roleRepo.findAll());
        
        return "user-form/user-view";
    }

}