/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.bazar.Servicio;

import com.proyectofinal.bazar.Entidad.Producto;
import com.proyectofinal.bazar.Repositorio.IProductoRepositorio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class ProductoServicio implements IProductoServicio{
    
    @Autowired
   private IProductoRepositorio productoRepo;
    
    
    
    @Transactional
    @Override
    public void guardar(Producto prod) {
    
    productoRepo.save(prod);
    }

    @Override
    public void borrar(Long codProducto) {
  
    productoRepo.deleteById(codProducto);
    }

    @Override
    public List<Producto> productos() {
   
    return productoRepo.findAll();
    }
    
    @Transactional
    @Override
    public Producto modificarProducto(Producto prod) {
        productoRepo.save(prod);
        Producto producto = productoRepo.findById(prod.getCodProducto()).get();
        return producto;
    
    }

    @Override
    public List<Producto> faltaStock() {
        List<Producto>listaProducto  = this.productos();
        List<Producto>faltante = null;
        
        for (Producto aux : listaProducto) {
            
            if(aux.getCantidadDisponible()< 5){
                faltante.add(aux);
            }
            
            
        }
        
        return faltante;
        
        
    }

    @Override
    public Producto verProducto(Long codProducto) {
   return productoRepo.findById(codProducto).orElse(null);
    }
    
}
