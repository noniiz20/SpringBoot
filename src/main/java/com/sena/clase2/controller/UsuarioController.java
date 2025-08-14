package com.sena.clase2.controller;
import org.springframework.web.bind.annotation.RestController;

import com.sena.clase2.dto.UsuarioDto;
import com.sena.clase2.models.Usuario;
import com.sena.clase2.repositoryes.UsuarioRepositorio;
import com.sena.clase2.services.UsuarioServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;





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
    
    /*Metodos mediante arquitectura por capas*/

    @Autowired
    private UsuarioServices userServices;
    /*Consulta  el usuario por id */
    @GetMapping("/userServices/{id_usuario}")
    public ResponseEntity<UsuarioDto> getUsuario(@PathVariable Integer id_usuario) {
        return new ResponseEntity<>(userServices.getUsuario(id_usuario),HttpStatus.OK);
    }
    //Crea Usuario
    @PostMapping("/userser")
    public ResponseEntity<UsuarioDto>saveUsuario(@RequestBody UsuarioDto usuarioDto) {
        return new ResponseEntity<>(userServices.saveUsuario(usuarioDto),HttpStatus.CREATED);
    }
    @GetMapping("/userrs")
    public ResponseEntity<List<UsuarioDto>> getUsuarios() {
        return new ResponseEntity<>(userServices.getUsuarios(), HttpStatus.OK);
    }
    
    
}


