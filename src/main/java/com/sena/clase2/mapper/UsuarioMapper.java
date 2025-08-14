package com.sena.clase2.mapper;

import java.util.List;

import com.sena.clase2.dto.UsuarioDto;
import com.sena.clase2.models.Usuario;

public interface UsuarioMapper {

Usuario toUsuario(UsuarioDto usuarioDto); /*consultar */

UsuarioDto toUsuarioDto(Usuario usuario); /*crear */

List<UsuarioDto>toUsuarioDtoList(List<Usuario>usuarios);
}
