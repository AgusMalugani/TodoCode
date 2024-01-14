/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.bazar.Entidad;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Usuario
 */
@Entity
@Getter @Setter

public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codVenta;
    private LocalDate fechaVenta;
    private double total;
    //@OneToMany(mappedBy = "venta")
   // @OneToMany()
   // private List<Producto>listaProducto;
    
     @ManyToMany
    @JoinTable(
        name = "venta_producto",
        joinColumns = @JoinColumn(name = "cod_venta"),
        inverseJoinColumns = @JoinColumn(name = "cod_producto")
    )
     private List<Producto>listaProducto;
    
    
    @OneToOne()
    private Cliente cliente;

    public Venta() {
    }

    public Venta(Long codVenta, LocalDate fechaVenta, double total, List<Producto> listaProducto, Cliente cliente) {
        this.codVenta = codVenta;
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.listaProducto = listaProducto;
        this.cliente = cliente;
    }
    
    
    
    
}
