/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.bazar.Controlador;

import com.proyectofinal.bazar.DTO.mayorVentaDTO;
import com.proyectofinal.bazar.Entidad.Producto;
import com.proyectofinal.bazar.Entidad.Venta;
import com.proyectofinal.bazar.Servicio.IVentaServicio;
import com.proyectofinal.bazar.excepciones.MiException;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/venta")

public class VentaControlador {
    
        @Autowired
    private IVentaServicio ventaServi;
    
    @PostMapping("/crear")
    public String crear(@RequestBody Venta v){
            try {
                ventaServi.guardar(v);
                return "venta creada";
            } catch (MiException ex) {
            return ex.getMessage();    
            }
    
    }
    
    @DeleteMapping("/borrar/{codVenta}")
    public String borrar(@PathVariable Long codVenta){
        ventaServi.borrar(codVenta);
    
    return "venta borrada";
    }
    
    @GetMapping("/lista")
    public List<Venta>ventas(){
        
        return ventaServi.ventas();
    }
    
    @GetMapping("/detalle/{codVenta}")
    public Venta verVenta(@PathVariable Long codVenta){
        return ventaServi.verVenta(codVenta);
    }
    
    @PutMapping("/modificar/{codVenta}")
    public Venta modificar(@RequestBody Venta v){
        
            try {
                return ventaServi.modificarVenta(v);
            } catch (MiException ex) {
                return null;
            }
    }
    
    @GetMapping("/producto/{codVenta}")
    public List<Producto> productosDeVenta(@PathVariable Long codVenta){
        
        return ventaServi.productosDeVenta(codVenta);
    }
    
    @GetMapping("/detalleDia/{fechaVenta}")
    public String ventasDelDia(@PathVariable LocalDate fechaVenta){
        
        return ventaServi.montoVentasPorDia(fechaVenta);
        
    }
    
    @GetMapping("/mayor_venta")
    public mayorVentaDTO mayorVenta(){
        
        return ventaServi.mayorVenta();
    }
    
}
