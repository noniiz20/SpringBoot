package com.sena.clase2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDto {
private Integer id_usuario;
private String nombre;
private String apellido;
private String cuidad;
}
