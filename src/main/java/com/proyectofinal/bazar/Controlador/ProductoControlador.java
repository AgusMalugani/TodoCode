/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.bazar.Controlador;

import com.proyectofinal.bazar.Entidad.Producto;
import com.proyectofinal.bazar.Servicio.IProductoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/producto")
public class ProductoControlador {

    @Autowired
    private IProductoServicio productoServi;
    
    @PostMapping("/crear")
    @Transactional
    public String crear(@RequestBody Producto prod){
    productoServi.guardar(prod);
    return "producto creado";
    }
    
    @DeleteMapping("/borrar/{codProducto}")
    @Transactional
    public String borrar(@PathVariable Long codProducto){
        productoServi.borrar(codProducto);
    
    return "producto borrado";
    }
    
    @GetMapping("/lista")
    public List<Producto>productos(){
        
        return productoServi.productos();
    }
    

    
    @PutMapping("/modificar/{codProducto}")
    @Transactional
    public Producto modificar(@RequestBody Producto prod){
        
        return productoServi.modificarProducto(prod);
    }
    
    
    @GetMapping("/falta_stock")
    public List<Producto>faltaDeStock(){
        
        return productoServi.faltaStock();
    }
    
    
    
    
}



    





