/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.bazar.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Usuario
 */
@Entity
@Getter @Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codProducto;
    private String nombre;
    private String marca;
    private double costo;
    private Integer cantidadDisponible;
   /*
    @ManyToOne()
    @JoinColumn(name="codProducto")
    @JsonIgnore()
    private Venta venta;
   */ 
    // muchos productos pueden estar en una  venta
    
    

    public Producto() {
    }

    public Producto(Long codProducto, String nombre, String marca, double costo, Integer cantidadDisponible) {
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidadDisponible = cantidadDisponible;
    }
    
    
    
    
    
}

