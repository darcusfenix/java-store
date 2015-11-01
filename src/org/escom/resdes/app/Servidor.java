/*
 * The MIT License
 *
 * Copyright 2015 darcusfenix.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.escom.resdes.app;

import java.net.*;
import java.io.*;
import java.util.List;
import org.escom.resdes.model.Producto;
import org.escom.resdes.repository.ProductoRepository;
import org.escom.resdes.repository.ProductoRepositoryImp;

public class Servidor {
    
    public void Iniciar() throws Exception {
        try {
            //creamos el socketServer en el mismo puerto donde se comunica el cliente
            ServerSocket ss = new ServerSocket(4000);
            System.out.println("Servicio iniciado, esperando por cliente...");
            for (;;) {
                //creamos el socket del cliente
                Socket cl = ss.accept();

                cl.setSoTimeout(3000);

                System.out.println("Cliente conectado desde:" + cl.getInetAddress() + ":" + cl.getPort());
                //creamos el flujo de entrada para leer los datos que envía el cliente
                ObjectInputStream ois = new ObjectInputStream(cl.getInputStream());
                //obtenemos la cantidad de archivos a recibir
                Integer files = (Integer) ois.readObject();
                
                System.out.println("Archivos a recibir: " + files);

                for (int i = 0; i < files; i++) {
                    RecibeArchivo(ois);
                }
                ois.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void enviarProductos(){
        
    }
    
    public void enviarImagenes(){
        
    }

    public static void main(String[] args) {
        ProductoRepository pr = new ProductoRepositoryImp();
        /*
        Producto producto = new Producto();
        producto.setNombre("CHAMARRA PARA DAMA PEPE");
        producto.setDescripcion("CHAMARRA PARA DAMA PEPE");
        producto.setUrlImagen("/home/darcusfenix/Documentos/ESCOM/REDES-APPS/P2/imagenes/1040479852.jpg");
        pr.save(producto);
        
        
        List<Producto> productos = pr.getAll();
        System.out.println("[PRODUCTOS] " + productos);
        
        Producto producto = null;
        producto = pr.getById(2);
        producto.setNombre(producto.getNombre() + " EDITADO");
        producto.setDescripcion(producto.getDescripcion()+ " EDITADO");
        producto.setUrlImagen(producto.getUrlImagen()+ " EDITADO");
        pr.update(producto);
        pr.delete(producto);
        
        */
    }//main

    public static void RecibeArchivo(ObjectInputStream ois) throws IOException, ClassNotFoundException {

        String nombre = null;
        String path = null;
        long tam = 0;
        try {
            //obtenemos el nombre del archivo
            nombre = (String) ois.readObject();
            System.err.println(nombre);
            //obtenemos la direccion del archivo
            path = (String) ois.readObject();
            //obtenemos el tamaño del archivo
            tam = (Long) ois.readObject();
            System.out.println("\n\nArchivo a recibir: " + nombre + " \ntamaño: " + tam + " bytes-> ruta: " + path);

                   // int l=(int)(long)tam;
            //creamos el array de bytes paa leer los datos del archivo
            byte[] buf = new byte[1024];
            //obtenemos el archivo
            long leidos = 0, fin = tam, po = 0;
            int b_leidos = 0;
            //creamos el archivo que vamos a recibir, y lo ubicamos en la carpeta del proyecto
            FileOutputStream inFile = new FileOutputStream(nombre);

            while ((fin > 0) && (b_leidos = ois.read(buf, 0, (int) Math.min(buf.length, fin))) != -1) {

                inFile.write(buf, 0, b_leidos);
                inFile.flush();
                leidos += b_leidos;
                fin -= b_leidos;

                po = (leidos * 100) / tam;
                System.out.print("\nBytes leidos: " + po + " %");
            }//while
            //cerramos flujos
            inFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
