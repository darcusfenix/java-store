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
import org.escom.resdes.app.util.FTP;
import org.escom.resdes.app.util.FTPImp;
import org.escom.resdes.ui.client.StoreUI;

public class Cliente {

    private FTP ftp;
    File[] f;

    public Cliente() throws Exception {
        ftp = new FTPImp();
        f = ftp.selectFilesWithPath("PATH_SERVER/IMAGES");
        conectarse();
    }

    public void conectarse() throws Exception {

        try {
            //creamos el socket con la dirección y el puerto de comunicación
            Socket cl = new Socket(InetAddress.getByName("127.0.0.1"), 4040);
            cl.setSoTimeout(3000);
            System.out.println("Cliente conectado con servidor..\n transfiriendo archivo..");
            for (;;) {
                ObjectOutputStream oos = new ObjectOutputStream(cl.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(cl.getInputStream());

                //oos.writeObject(Propiedades.SOLICITUD_IMG);
                recibirImagenes(ois);
                recibirCatalogo(ois);
                showUI();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean recibirImagenes(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        Integer files = (Integer) ois.readObject();

        System.out.println("Archivos a recibir: " + files);

        for (int i = 0; i < files; i++) {
            ftp.recibeArchivo(ois, "PATH_CLIENT/IMAGES/");
        }
        return true;
    }

    public boolean recibirCatalogo(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        Integer files = (Integer) ois.readObject();
        System.out.println("Archivos a recibir: " + files);
        for (int i = 0; i < files; i++) {
            ftp.recibeArchivo(ois, "PATH_CLIENT/CATALOGO/");
        }
        return true;
    }
    public void showUI(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StoreUI().setVisible(true);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new Cliente();
    }
}
