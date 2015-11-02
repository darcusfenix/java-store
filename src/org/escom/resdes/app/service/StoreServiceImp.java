/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.escom.resdes.app.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import org.escom.resdes.app.config.Propiedades;
import org.escom.resdes.model.Catalogo;
import org.escom.resdes.model.Cesta;
import org.escom.resdes.model.Orden;
import org.escom.resdes.model.Producto;
import org.escom.resdes.repository.ProductoRepository;
import org.escom.resdes.repository.ProductoRepositoryImp;

/**
 *
 * @author darcusfenix
 */
public class StoreServiceImp implements StoreService {

    private ProductoRepository pr;

    public StoreServiceImp() {
        this.pr = new ProductoRepositoryImp();
    }

    @Override
    public Catalogo getCatalogo() {
        Catalogo catalogo = null;
        try {
            FileInputStream fileIn = new FileInputStream(Propiedades.PATH + "PATH_CLIENT/CATALOGO/catalogo.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            catalogo = (Catalogo) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            System.err.println(i.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
        }
        return catalogo;
    }

    @Override
    public Cesta getCesta() {
        Cesta cesta = null;
        try {
            FileInputStream fileIn = new FileInputStream(Propiedades.PATH + "PATH_CLIENT/CESTA/cesta.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            cesta = (Cesta) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            System.err.println(i.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
        }
        return cesta;
    }

    @Override
    public void saveCesta(Cesta cesta) {
        System.out.println(cesta);
        try {
            FileOutputStream fileOut = new FileOutputStream(Propiedades.PATH + "PATH_CLIENT/CESTA/cesta.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(cesta);
            out.close();
            fileOut.close();
        } catch (IOException io) {
            System.err.println(io.getMessage());
        }
    }

    @Override
    public boolean puedoComprar(Integer cantidad, Integer sku) {
        boolean flag = false;
        Producto producto = pr.getById(sku);

        if (producto.getCantidad() > 0 && cantidad > 0) {
            flag = cantidad <= producto.getCantidad() ? true : false;
        }

        return flag;
    }

    @Override
    public void clearCesta() {
        Producto producto = null;
        return;
    }

    @Override
    public void generarTikect(Cesta cesta, File file) {
        File f = new File(file.getAbsolutePath() + "/TIKECT-COMPRA.txt");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(f);
            writer.println("******************* TIKECT *******************");
            writer.println("\n \n");
            for (Orden orden : cesta.getOrdenes()) {
                writer.print("PRODUCTO:        " + orden.getProducto().getNombre() + "\t");
                writer.print("CANTIDAD:        " + orden.getCantidad() + "\t");
                writer.print("PRECIO UNITARIO: $ " + orden.getProducto().getCosto() + "\t");
                writer.println("\n\n");
            }
            writer.println("**** TOTAL ****");
            writer.println("\n \n");
            writer.print("TOTAL: $ " + cesta.getTotal() + "\t");
            writer.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void finalizarCompra(Cesta cesta) {
        ProductoRepository pr = new ProductoRepositoryImp();
        new StoreServiceImp().saveCesta(new Cesta());
        for (Orden orden : cesta.getOrdenes()) {
            Producto producto = pr.getById(orden.getProducto().getSku());
            producto.setCantidad(producto.getCantidad() - orden.getCantidad());
            pr.update(producto);
        }
    }
}
