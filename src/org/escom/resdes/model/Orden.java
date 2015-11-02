/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.escom.resdes.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author darcusfenix
 */
public class Orden implements Serializable{
    private Integer id;
    private Producto producto;
    private Integer cantidad;
    
    public Orden(){
        this.producto = new Producto();
        this.cantidad = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Orden{" + "id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + '}';
    }
    
}
