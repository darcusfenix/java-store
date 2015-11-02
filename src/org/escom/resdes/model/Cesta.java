/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.escom.resdes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author darcusfenix
 */
public class Cesta implements Serializable{
    private List<Orden> ordenes;
    private float total;
    
    public Cesta(){
        this.ordenes = new ArrayList<Orden>();
        this.total = 0f;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cesta{" + "ordenes=" + ordenes + ", total=" + total + '}';
    }
    
}
