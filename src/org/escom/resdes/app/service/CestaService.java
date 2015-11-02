/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.escom.resdes.app.service;

import org.escom.resdes.model.Producto;

/**
 *
 * @author darcusfenix
 */
public interface CestaService {

    void addProductoToCesta(Producto producto, Integer cantidad);

    void removeProductoOfCesta(Producto producto);

}
