/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectofinal.bazar.Servicio;

import com.proyectofinal.bazar.DTO.mayorVentaDTO;
import com.proyectofinal.bazar.Entidad.Producto;
import com.proyectofinal.bazar.Entidad.Venta;
import com.proyectofinal.bazar.excepciones.MiException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IVentaServicio {
    public void guardar(Venta v) throws MiException ;
    
    public void borrar(Long codVenta);
    
    public List<Venta>ventas();
    
    public Venta verVenta(Long codVenta);
    
    public Venta modificarVenta(Venta v) throws MiException ;
    
    public List<Producto> productosDeVenta(Long codVenta);
    
    public String montoVentasPorDia(LocalDate fechaVenta);
    
    public mayorVentaDTO mayorVenta();
    
    public void validar(Venta venta)throws MiException;
    
}
