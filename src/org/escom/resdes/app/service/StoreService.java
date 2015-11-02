/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.escom.resdes.app.service;

import org.escom.resdes.model.Catalogo;
import org.escom.resdes.model.Cesta;
import org.escom.resdes.model.Orden;

/**
 *
 * @author darcusfenix
 */
public interface StoreService {

    void addProductoToCesta(Orden orden);

    void clearCesta();
    
    void saveCesta(Cesta cesta);

    Catalogo getCatalogo();

    Cesta getCesta();

    Orden getProductoOfCesta(Integer id);

    void removeProductoOfCesta(Orden orden);

    void updateProductoToCesta(Orden orden);
    
}
