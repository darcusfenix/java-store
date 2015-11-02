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

public class Cliente {

    private FTP ftp;
    File[] f;

    public Cliente() throws Exception {
        ftp = new FTPImp();
        f = ftp.selectFilesWithPath("PATH_SERVER/IMAGES");
        conectarse();
    }

    public void conectarse() throws Exception {
        int i;

        try {
            //creamos el socket con la dirección y el puerto de comunicación
            Socket cl = new Socket(InetAddress.getByName("127.0.0.1"), 4040);
            cl.setSoTimeout(3000);
            System.out.println("Cliente conectado con servidor..\n transfiriendo archivo..");

            ObjectOutputStream oos = new ObjectOutputStream(cl.getOutputStream());

            oos.writeObject(f.length);

            for (i = 0; i < f.length; i++) {
                ftp.enviarArchivo(f[i].getAbsolutePath(), f[i].getName(), f[i].length(), oos);
            }

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new Cliente();
    }
}
