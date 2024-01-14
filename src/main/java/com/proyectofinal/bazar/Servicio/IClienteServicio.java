/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectofinal.bazar.Servicio;

import com.proyectofinal.bazar.Entidad.Cliente;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IClienteServicio {
    public void guardar(Cliente cli);
    
    public void borrar(Long idCliente);
    
    public List<Cliente>clientes();
    
    public Cliente verCliente(Long idCliente);
    
    public Cliente modificarCliente(Cliente cli);
    
    
    
}
