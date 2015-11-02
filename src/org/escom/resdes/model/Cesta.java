/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.escom.resdes.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author darcusfenix
 */
public class Cesta implements Serializable{
    private List<Orden> cesta;
    private float total;

    public List<Orden> getCesta() {
        return cesta;
    }

    public void setCesta(List<Orden> cesta) {
        this.cesta = cesta;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
}
