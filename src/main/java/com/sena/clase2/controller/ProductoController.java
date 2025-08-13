package com.sena.clase2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sena.clase2.models.Producto;
import com.sena.clase2.repositoryes.ProductoRepositorio;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class ProductoController {
@Autowired
private ProductoRepositorio prodRepo;

@GetMapping("/prodCon")
public String getMethodName() {
    return new String("conectando desde ProductoController");
}
@GetMapping("/products")
public String ListaProductos() {
    return prodRepo.findAll().toString();
}
@GetMapping("/ListaProductos")
public List<Producto> Productoslistas() {
        return prodRepo.findAll();
}
@PostMapping("/agregarProducto")
public Producto crearProducto(@RequestBody Producto producto) {
    return prodRepo.save(producto);
}
@DeleteMapping("/products/{id}")
    public String eliminarproducto(@PathVariable Integer id){
        prodRepo.deleteById((id));
        return "";
}
@PutMapping("producto/{id}")
public String productupdate(@PathVariable String id, @RequestBody Producto producto) {
    Producto productupdate = prodRepo.findById(Integer.parseInt(id)).orElse(null);
    if (productupdate == null) {
        return "producto no encontrado";
    }
    productupdate.setNombre(producto.getNombre());
    productupdate.setCategoria(producto.getCategoria());
    productupdate.setPrecio(producto.getPrecio());
    prodRepo.save(productupdate);
    return "producto actualizado";
    }
    @GetMapping("/products/categoria/{categoria}")
    public List<Producto> getProductosByCategoria (@PathVariable String categoria) {
        return prodRepo.findByCategoria(categoria);
    }
    
    
}
