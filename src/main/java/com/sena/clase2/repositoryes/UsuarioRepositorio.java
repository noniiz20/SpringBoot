package com.sena.clase2.repositoryes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.clase2.models.Usuario;

public interface UsuarioRepositorio extends JpaRepository <Usuario,Integer>{

    List<Usuario> findByNombre(String nombre);

};
