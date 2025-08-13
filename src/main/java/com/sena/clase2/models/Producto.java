package com.sena.clase2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="productos")

public class Producto {
@Id
@Column(name= "id_producto")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id_producto;
private String nombre;
private String categoria;
private Double precio;
}
