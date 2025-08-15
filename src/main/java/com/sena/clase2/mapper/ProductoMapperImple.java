package com.sena.clase2.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sena.clase2.dto.ProductoDto;
import com.sena.clase2.models.Producto;

@Component
public class ProductoMapperImple implements ProductoMapper{

    @Override
    public Producto toProducto(ProductoDto productoDto){
        if (productoDto == null) {
            return null;
        }
    
    Producto producto = new Producto();
    producto.setId_producto(productoDto.getId_pro());
    producto.setNombre(productoDto.getNomP());
    producto.setCategoria(productoDto.getCate());
    producto.setPrecio(productoDto.getPrec());
    return producto;
    }
    @Override
    public ProductoDto toProductoDto(Producto producto){
        if(producto == null){
            return null;
        }
        ProductoDto productoDto = new ProductoDto();
        productoDto.setId_pro(producto.getId_producto());
        productoDto.setNomP(producto.getNombre());
        productoDto.setCate(producto.getCategoria());
        productoDto.setPrec(producto.getPrecio());
        return productoDto;
    }

    @Override
    public List<ProductoDto> toProductoDtoList(List<Producto>productos){
    if (productos==null) {
    return List.of();
    }
    List<ProductoDto>productoDtos = new ArrayList<ProductoDto>(productos.size());
    for(Producto producto : productos){
        productoDtos.add(toProductoDto(producto));
    }
    return productoDtos;
    }

    @Override
    public void updateProducto(Producto producto, ProductoDto productoDto){
        if (productoDto == null) {
            return;
        }
        producto.setNombre(productoDto.getNomP());
        producto.setCategoria(productoDto.getCate());
        producto.setPrecio(productoDto.getPrec());
    }
}
