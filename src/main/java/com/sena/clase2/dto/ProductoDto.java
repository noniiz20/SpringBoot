package com.sena.clase2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductoDto {
private Integer id_pro;
private String nomP;
private String cate;
private Double prec;
}
