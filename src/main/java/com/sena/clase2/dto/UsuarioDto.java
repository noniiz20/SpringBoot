package com.sena.clase2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDto {
private Integer id;
private String nom;
private String ape;
private String ciu;
}
