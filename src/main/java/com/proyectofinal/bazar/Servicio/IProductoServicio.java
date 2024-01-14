/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectofinal.bazar.Servicio;

import com.proyectofinal.bazar.Entidad.Producto;
import com.proyectofinal.bazar.excepciones.MiException;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IProductoServicio {
    public void guardar(Producto prod);
    
    public void borrar(Long codProducto);
    
    public List<Producto>productos();
    
    public Producto verProducto(Long codProducto);
    
    public Producto modificarProducto(Producto prod);
    
    public List<Producto>faltaStock();
    
    
    
}
