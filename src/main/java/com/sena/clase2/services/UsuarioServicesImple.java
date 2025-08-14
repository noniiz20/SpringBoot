package com.sena.clase2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.clase2.dto.UsuarioDto;
import com.sena.clase2.mapper.UsuarioMapper;
import com.sena.clase2.models.Usuario;
import com.sena.clase2.repositoryes.UsuarioRepositorio;

@Service
public class UsuarioServicesImple implements UsuarioServices{

@Autowired
private UsuarioRepositorio userRepo;

@Autowired
private UsuarioMapper userMapper;


@Override
public UsuarioDto getUsuario(Integer id_usuario){
Usuario usuario = userRepo.findById(id_usuario).get();
return userMapper.toUsuarioDto(usuario);
}

@Override
public UsuarioDto saveUsuario(UsuarioDto usuarioDto){
    Usuario usuario = userMapper.toUsuario(usuarioDto);
    return userMapper.toUsuarioDto((userRepo.save(usuario)));
}
@Override
public List<UsuarioDto> getUsuarios(){
List<Usuario> usuarios=userRepo.findAll();
return userMapper.toUsuarioDtoList(usuarios);
}
}

