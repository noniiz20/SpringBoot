package com.sena.clase2.controller;
import org.springframework.web.bind.annotation.RestController;

import com.sena.clase2.models.Usuario;
import com.sena.clase2.repositoryes.UsuarioRepositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class UsuarioController {
@Autowired
private UsuarioRepositorio userRepo;
@GetMapping("/usuCon")
    public String getMethodName() {
        return new String("conectando desde UsuarioController");
    }
    @GetMapping("/users")
    public String ListarUsuarios() {
        return userRepo.findAll().toString();
    }
    @GetMapping("/ListaUsuarios")
    public List<Usuario> Usuarioslistas() {
        return userRepo.findAll();
    }

    @PostMapping("/agregarUsuario")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return userRepo.save(usuario);
    }

    @DeleteMapping ("/users/{id}")
    public String eliminarusuario(@PathVariable Integer id) {
    userRepo.deleteById(id);
    return "";
    }
    @PutMapping("usuario/{id}")
    public String userupdate(@PathVariable String id, @RequestBody Usuario usuario) {
        Usuario userupdate = userRepo.findById(Integer.parseInt(id)).orElse(null);
        if (userupdate == null) {
            return"usuario no encontrado";
        }
        userupdate.setNombre(usuario.getNombre());
        userupdate.setApellido(usuario.getApellido());
        userupdate.setCuidad(usuario.getCuidad());
        userRepo.save(userupdate);
        return "Usuario Actualizado";
    }
    @GetMapping("/users/nombre/{nombre}")
    public List< Usuario> getUsuariosByNombre(@PathVariable String nombre) {
        return userRepo.findByNombre(nombre);
    }
    
}


