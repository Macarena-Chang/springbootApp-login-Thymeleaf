package com.example.demo.repositories;

import com.example.demo.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//recordar poner entre diamantes el tipo de obj q queremos implementar el repo- Usuario, Long (porque el Id es tipo Long)
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    
}