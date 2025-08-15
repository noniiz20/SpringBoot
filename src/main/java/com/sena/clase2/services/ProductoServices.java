package com.sena.clase2.services;

import java.util.List;

import com.sena.clase2.dto.ProductoDto;

public interface ProductoServices {

    public ProductoDto getProducto(Integer id_producto);
    public ProductoDto saveProducto(ProductoDto productoDto);
    public List<ProductoDto> getProductos();
    public ProductoDto deleteProducto(Integer id_producto);
    public ProductoDto updateproducto(Integer id_producto,ProductoDto productoDto);


}
