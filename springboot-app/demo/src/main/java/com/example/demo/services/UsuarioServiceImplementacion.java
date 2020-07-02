package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Usuario;
import com.example.demo.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImplementacion implements UsuarioService {


    //usar repository 
    @Autowired
    UsuarioRepository usuarioRepo;

    @Override
    public List<Usuario> getAllUsers() {
       
        List<Usuario> lista = new ArrayList<>(); 
        usuarioRepo.findAll().forEach(lista::add);
        return lista; 
    }


   
    
}