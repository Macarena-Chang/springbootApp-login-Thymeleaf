package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Usuario;

import org.springframework.stereotype.Service;

@Service
public interface UsuarioService{

    //metodo para iterar Usuarios 
    public List<Usuario> getAllUsers();
    
}