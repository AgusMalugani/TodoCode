/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.bazar.DTO;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Usuario
 */
@Setter @Getter
public class mayorVentaDTO {
    private  Long codVenta;
    private double total;
    private Integer cantidadProducto;
    private String nombreCliente;
    private String apellidoCliente;

    public mayorVentaDTO() {
    }

    public mayorVentaDTO(Long codVenta, double total, Integer cantidadProducto, String nombreCliente, String apellidoCliente) {
        this.codVenta = codVenta;
        this.total = total;
        this.cantidadProducto = cantidadProducto;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }
    
    
    
    
}
