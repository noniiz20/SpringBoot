package com.sena.clase2.mapper;

import com.sena.clase2.dto.UsuarioDto;
import com.sena.clase2.models.Usuario;

public interface UsuarioMapper {

Usuario toUsuario(UsuarioDto usuarioDto);

UsuarioDto toUsuarioDto(Usuario usuario);
}
