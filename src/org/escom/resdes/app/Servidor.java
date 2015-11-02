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
import org.escom.resdes.app.config.Propiedades;
import org.escom.resdes.app.util.FTP;
import org.escom.resdes.app.util.FTPImp;
import org.escom.resdes.repository.ProductoRepository;
import org.escom.resdes.repository.ProductoRepositoryImp;

public class Servidor {

    private FTP ftp;

    public Servidor() throws Exception {
        ftp = new FTPImp();
        iniciar(4040);
    }

    public void iniciar(Integer puerto) throws Exception {
        try {
            ServerSocket ss = new ServerSocket(puerto);
            System.out.println("Servicio iniciado, esperando por cliente...");
            for (;;) {
                Socket cl = ss.accept();
                cl.setSoTimeout(3000);
                //System.out.println("Cliente conectado desde:" + cl.getInetAddress() + ":" + cl.getPort());

                ObjectInputStream ois = new ObjectInputStream(cl.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(cl.getOutputStream());

                // EL SERVIDOR RECIBE SOLICITUDES
//                Integer solicitud = (Integer) ois.readObject();

                enviarImagenes(oos);
                enviarCatalogo(oos);
              
                //Integer option = (Integer) ois.readObject();
                /* PROCESO FTP NORMAL
                 //obtenemos la cantidad de archivos a recibir
                 Integer files = (Integer) ois.readObject();
                
                 System.out.println("Archivos a recibir: " + files);

                 for (int i = 0; i < files; i++) {
                 ftp.recibeArchivo(ois, "PATH_SERVER/FTP/");
                 }
                 */
               // ois.close();
             //  oos.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enviarProductos() {

    }

    public void enviarImagenes(ObjectOutputStream oos) throws Exception {
        File[] f = null;
        f = ftp.selectFilesWithPath("PATH_SERVER/IMAGES");
        oos.writeObject(f.length);
        for (File f1 : f) {
            ftp.enviarArchivo(f1.getAbsolutePath(), f1.getName(), f1.length(), oos);
        }
    }
    
    public void enviarCatalogo(ObjectOutputStream oos) throws Exception {
        ProductoRepository pr = new ProductoRepositoryImp();
        pr.saveCatalogoOnServer();
        
        File[] f = null;
        f = ftp.selectFilesWithPath("PATH_SERVER/CATALOGO");
        oos.writeObject(f.length);
        for (File f1 : f) {
            ftp.enviarArchivo(f1.getAbsolutePath(), f1.getName(), f1.length(), oos);
        }
    }

    public static void main(String[] args) throws Exception {
        new Servidor();
    }
}
