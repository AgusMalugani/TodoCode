/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.bazar.Controlador;

import com.proyectofinal.bazar.Entidad.Cliente;
import com.proyectofinal.bazar.Servicio.IClienteServicio;
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
@RequestMapping("/cliente")
public class ClienteControlador {
    @Autowired
    private IClienteServicio clienteServi;
    
    @PostMapping("/crear")
    @Transactional
    public String crear(@RequestBody Cliente cliente){
    clienteServi.guardar(cliente);
    return "cliente creado";
    }
    
    @DeleteMapping("/borrar/{idCliente}")
    @Transactional
    public String borrar(@PathVariable Long idCliente){
        clienteServi.borrar(idCliente);
    
    return "cliente borrado";
    }
    
    @GetMapping("/lista")
    public List<Cliente>clientes(){
        
        return clienteServi.clientes();
    }
    
    @GetMapping("/detalle/{idCliente}")
    public Cliente verCliente(@PathVariable Long idCliente){
        return clienteServi.verCliente(idCliente);
    }
    
    @PutMapping("/modificar/{idCliente}")
    @Transactional
    public Cliente modificar(@RequestBody Cliente cliente){
        
        return clienteServi.modificarCliente(cliente);
    }
    
}













