/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectofinal.bazar.Repositorio;

import com.proyectofinal.bazar.Entidad.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public interface IVentaRepositorio extends JpaRepository<Venta, Long>{
    @Query("SELECT v FROM Venta v LEFT JOIN FETCH v.listaProducto WHERE v.codVenta = :codVenta")
Venta findVentaWithProductos(@Param("codVenta") Long codVenta);

    
}
