package com.sena.clase2.services;

import java.util.List;

import com.sena.clase2.dto.UsuarioDto;

public interface UsuarioServices{

public UsuarioDto getUsuario(Integer id_usuario);
public UsuarioDto saveUsuario(UsuarioDto usuarioDto);
public List<UsuarioDto> getUsuarios();
public  UsuarioDto deleteUsuario(Integer id_Usuario);

}

