package com.sena.clase2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.clase2.dto.ProductoDto;
import com.sena.clase2.mapper.ProductoMapper;
import com.sena.clase2.models.Producto;
import com.sena.clase2.repositoryes.ProductoRepositorio;

@Service
public class ProductoServicesImple implements ProductoServices {

@Autowired
private ProductoRepositorio prodRepo;

@Autowired
private ProductoMapper productoMapper;

@Override
public ProductoDto getProducto(Integer id_producto){
Producto producto= prodRepo.findById(id_producto).get();
return productoMapper.toProductoDto(producto);
}
@Override
public ProductoDto saveProducto(ProductoDto productoDto){
    Producto producto = productoMapper.toProducto(productoDto);
    return productoMapper.toProductoDto((prodRepo.save(producto)));
}
@Override
public List<ProductoDto> getProductos(){
List<Producto> productos=prodRepo.findAll();
return productoMapper.toProductoDtoList(productos);
}
@Override
public ProductoDto deleteProducto(Integer id_producto){
    Producto producto = prodRepo.findById(id_producto).get();
    prodRepo.delete(producto);
    return productoMapper.toProductoDto(producto);
}
@Override
public ProductoDto updateproducto(Integer id_producto, ProductoDto productoDto){
    Producto producto=prodRepo.findById((id_producto)).get();
    return productoMapper.toProductoDto(prodRepo.save(producto));
}
}
