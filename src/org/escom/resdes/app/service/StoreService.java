/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.escom.resdes.app.service;

import java.io.File;
import org.escom.resdes.model.Catalogo;
import org.escom.resdes.model.Cesta;

/**
 *
 * @author darcusfenix
 */
public interface StoreService {

    void clearCesta();

    void saveCesta(Cesta cesta);

    Catalogo getCatalogo();

    Cesta getCesta();

    boolean puedoComprar(Integer cantidad, Integer sku);
    
    void generarTikect(Cesta cesta, File file);
    
    void finalizarCompra(Cesta cesta);
}
