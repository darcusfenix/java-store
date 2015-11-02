/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.escom.resdes.app.service;

import java.util.List;
import org.escom.resdes.model.Cesta;
import org.escom.resdes.model.Orden;
import org.escom.resdes.model.Producto;

/**
 *
 * @author darcusfenix
 */
public class CestaServiceImp implements CestaService {

    private StoreService ss;

    public CestaServiceImp() {
        this.ss = new StoreServiceImp();
    }

    @Override
    public void addProductoToCesta(Producto producto, Integer cantidad) {

        if (!ss.puedoComprar(cantidad, producto.getSku())) {
            return;
        }

        Cesta cesta = null;
        cesta = ss.getCesta();
        List<Orden> ordenes = null;
        ordenes = cesta.getOrdenes();
        boolean estaProducto = false;

        for (Orden orden : ordenes) {
            if (orden.getProducto().getSku().equals(producto.getSku())) {
                estaProducto = true;
                orden.setCantidad(cantidad);
            }
        }
        if (!estaProducto) {
            Orden orden = new Orden();
            orden.setProducto(producto);
            orden.setCantidad(cantidad);
            ordenes.add(orden);
        }
        cesta.setOrdenes(ordenes);
        ss.saveCesta(cesta);
    }

    @Override
    public void removeProductoOfCesta(Producto producto) {
        Cesta cesta = null;
        cesta = ss.getCesta();
        List<Orden> ordenes = null;
        ordenes = cesta.getOrdenes();
        for (Orden orden : ordenes) {
            if (orden.getProducto().getSku().equals(producto.getSku())) {
                ordenes.remove(orden);
            }
        }
        cesta.setOrdenes(ordenes);
        ss.saveCesta(cesta);
    }
}
