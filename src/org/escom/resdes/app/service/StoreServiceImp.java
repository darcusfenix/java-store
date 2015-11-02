/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.escom.resdes.app.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import org.escom.resdes.app.config.Propiedades;
import org.escom.resdes.model.Catalogo;
import org.escom.resdes.model.Cesta;
import org.escom.resdes.model.Orden;
import org.escom.resdes.model.Producto;

/**
 *
 * @author darcusfenix
 */
public class StoreServiceImp implements StoreService {

    @Override
    public Catalogo getCatalogo() {
        Catalogo catalogo = null;
        try {
            FileInputStream fileIn = new FileInputStream(Propiedades.PATH + "PATH_CLIENT/CATALOGO/catalogo.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            catalogo = (Catalogo) in.readObject();
            in.close();
            fileIn.close();
            System.err.println(catalogo.getProductos());
        } catch (IOException i) {
            System.err.println(i.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }finally{
        }
        return catalogo;
    }

    @Override
    public Cesta getCesta() {
        Cesta cesta = null;
        return cesta;
    }
    @Override
    public void saveCesta(Cesta cesta) {
        
        return;
    }

    @Override
    public void addProductoToCesta(Orden orden) {
        Producto producto = null;
        return;
    }

    @Override
    public void removeProductoOfCesta(Orden orden) {
        Producto producto = null;
        return;
    }

    @Override
    public Orden getProductoOfCesta(Integer id) {
        Orden orden = null;
        return orden;
    }

    @Override
    public void updateProductoToCesta(Orden orden) {
        Producto producto = null;
        return;
    }

    @Override
    public void clearCesta() {
        Producto producto = null;
        return;
    }
}
