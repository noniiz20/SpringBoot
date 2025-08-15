package com.sena.clase2.mapper;

import java.util.ArrayList;
import java.util.List;

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
    usuario.setId_usuario(usuarioDto.getId());
    usuario.setNombre(usuarioDto.getNom());
    usuario.setApellido(usuarioDto.getApe());
    usuario.setCuidad(usuarioDto.getCiu());
    return usuario;
    }

    @Override
    public UsuarioDto toUsuarioDto(Usuario usuario){
        if(usuario == null){
            return null;
        }
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuario.getId_usuario());
        usuarioDto.setNom(usuario.getNombre());
        usuarioDto.setApe(usuario.getApellido());
        usuarioDto.setCiu(usuario.getCuidad());
        return usuarioDto;
    }
    @Override
    public List<UsuarioDto> toUsuarioDtoList(List<Usuario>usuarios){
        if (usuarios== null) {
        return List.of();
        }
        List<UsuarioDto>usuarioDtos = new ArrayList<UsuarioDto>(usuarios.size());
        for(Usuario usuario : usuarios){
            usuarioDtos.add(toUsuarioDto(usuario));
        }
        return usuarioDtos;
    }

    @Override
    public void updateUsuario (Usuario usuario, UsuarioDto usuarioDto) {
        if (usuarioDto == null) {
            return;
        }
        usuario.setNombre(usuarioDto.getNom());
        usuario.setApellido(usuarioDto.getApe());
        usuario.setCuidad(usuarioDto.getCiu());
    }

}

