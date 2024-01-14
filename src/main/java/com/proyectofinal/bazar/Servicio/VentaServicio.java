/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.bazar.Servicio;

import com.proyectofinal.bazar.DTO.mayorVentaDTO;
import com.proyectofinal.bazar.Entidad.Producto;
import com.proyectofinal.bazar.Entidad.Venta;
import com.proyectofinal.bazar.Repositorio.IVentaRepositorio;
import com.proyectofinal.bazar.excepciones.MiException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class VentaServicio implements IVentaServicio {

    @Autowired
    private IVentaRepositorio ventaRepo;
    @Autowired
    private IProductoServicio productoServi;

    @Transactional
    @Override
    public void guardar(Venta v) throws MiException {
        
        this.validar(v);
        
        double totalV = 0;
        
        for (Producto aux : v.getListaProducto()) {
          Producto p =  productoServi.verProducto(aux.getCodProducto());
            totalV = totalV + p.getCosto();
            
            // al vender un producto, debo descontarlo del stock
            p.setCantidadDisponible(p.getCantidadDisponible()-1);
            
            productoServi.modificarProducto(p);
            // modifico el producto, y lo guardo en la bd
        }
        

        v.setTotal(totalV);

        ventaRepo.save(v);
    }

    @Override
    public void borrar(Long codVenta) {

        ventaRepo.deleteById(codVenta);
    }

    @Override
    public List<Venta> ventas() {
        return ventaRepo.findAll();
    }

    @Override
    public Venta verVenta(Long codVenta) {
       try{
            Venta venta = ventaRepo.findById(codVenta).orElse(null);
    
        return venta;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Transactional
    @Override
    public Venta modificarVenta(Venta v) throws MiException {
        this.validar(v);
        Optional<Venta>respuesta = ventaRepo.findById(v.getCodVenta());
         
        
        if(respuesta.isPresent()){
          Venta venta  = respuesta.get();
        ventaRepo.save(venta);
        return venta;
        }
        return null; // si estaba en la bd, retorna la  venta, y si no, retorna null

    }

    @Override
    public List<Producto> productosDeVenta(Long codVenta) {
        // traigo la venta
         Optional<Venta>respuesta = ventaRepo.findById(codVenta);
      
        
        if(respuesta.isPresent()){
          Venta venta  = respuesta.get();
        return venta.getListaProducto();
    }
        return null;
        
    }

    //tengo q saber las ventas de determinado dia, y sumar la plata de esas ventas y la cantidad de ventas de ese dia
    @Override
    public String montoVentasPorDia(LocalDate fechaVenta) {
        List<Venta> listaVentas = this.ventas();
        List<Venta> ventasDelDia = null;
        int cont = 0;
        for (Venta aux : listaVentas) {
            if (aux.getFechaVenta().equals(fechaVenta)) {
                ventasDelDia.add(aux);
                cont++;
            }
        }
        if(cont != 0){
        double montoTotal = 0;

        for (Venta aux : ventasDelDia) {
            montoTotal = montoTotal + aux.getTotal();
        }

        return "La cantidad de ventas de la fecha: " + fechaVenta + " es de " + ventasDelDia.size() + " ventas. Y el monto total es: $" + montoTotal;
        } else{
            return "no hay ventas realizadas en esa fecha.";
        }
    }

    @Override
    public mayorVentaDTO mayorVenta() {

        List<Venta> listaVentas = this.ventas();
        double mayor = 0;
        Long idMayor = 0L;
        for (Venta aux : listaVentas) {
            if (aux.getTotal() > mayor) {
                idMayor = aux.getCodVenta();
            }
        }

        Venta venta = this.verVenta(idMayor);

        mayorVentaDTO mayorVenta = new mayorVentaDTO();

        mayorVenta.setCantidadProducto(venta.getListaProducto().size());
        mayorVenta.setCodVenta(idMayor);
        mayorVenta.setTotal(venta.getTotal());
        mayorVenta.setNombreCliente(venta.getCliente().getNombre());
        mayorVenta.setApellidoCliente(venta.getCliente().getApellido());

        return mayorVenta;
    }

    @Override
    public void validar(Venta venta)throws MiException{
        
        if(venta.getFechaVenta() == null){
          throw new MiException("La fecha de venta no puede estar vacia");
        }
        
        
        if(venta.getCliente() == null){
             throw new MiException("La venta tiene que tener asociado un cliente");
        }
        
        
        if(venta.getListaProducto()== null){
             throw new MiException("La venta tiene que tener el listado de productos vendidos");
        }
        
    
    }
    
    
    
    
  
    
    
    
    

}
