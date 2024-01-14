/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.bazar.Servicio;

import com.proyectofinal.bazar.Entidad.Cliente;
import com.proyectofinal.bazar.Repositorio.IClienteRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class ClienteServicio implements IClienteServicio {

    @Autowired
    private IClienteRepositorio clienteRepo;
    @Transactional
    @Override
    public void guardar(Cliente cli) {
        clienteRepo.save(cli);

    }

    @Override
    public void borrar(Long idCliente) {

        clienteRepo.deleteById(idCliente);

    }

    @Override
    public List<Cliente> clientes() {
        List<Cliente> listaClientes = clienteRepo.findAll();
        return listaClientes;

    }

    @Override
    public Cliente verCliente(Long idCliente) {
   
    return clienteRepo.findById(idCliente).orElse(null);
    }
    
    @Transactional
    @Override
    public Cliente modificarCliente(Cliente cli) {
       
        clienteRepo.save(cli);
        
        Cliente cliente = this.verCliente(cli.getIdCliente());
        
        return cliente;
    
    }

}
