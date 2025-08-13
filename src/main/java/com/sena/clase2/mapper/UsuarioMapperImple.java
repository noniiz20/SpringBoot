package com.sena.clase2.mapper;

import org.springframework.stereotype.Component;

import com.sena.clase2.dto.UsuarioDto;
import com.sena.clase2.models.Usuario;

@Component
public class UsuarioMapperImple implements UsuarioMapper{

    @Override
    public Usuario toUsuario(UsuarioDto usuarioDto) {
    if(usuarioDto == null){
    return null;
    }

    Usuario usuario = new Usuario();
    usuario.setId_usuario(usuarioDto.getId_usuario());
    usuario.setNombre(usuario.getNombre());
    usuario.setApellido(usuario.getApellido());
    usuario.setCuidad(usuario.getCuidad());
    return usuario;
    }

    @Override
    public UsuarioDto toUsuarioDto(Usuario usuario){
        if(usuario == null){
            return null;
        }
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId_usuario(usuario.getId_usuario());
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setApellido(usuarioDto.getApellido());
        usuarioDto.setCuidad(usuarioDto.getCuidad());
        return usuarioDto;
    }
}

