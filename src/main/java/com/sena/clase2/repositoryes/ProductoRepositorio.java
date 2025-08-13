package com.sena.clase2.repositoryes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.clase2.models.Producto;

public interface ProductoRepositorio extends JpaRepository <Producto,Integer> {

    List<Producto> findByCategoria(String categoria);

}
