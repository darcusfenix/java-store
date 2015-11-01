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
package app;

import java.net.*;
import java.io.*;
import javax.swing.JFileChooser;

public class Cliente {

    public static void main(String[] args) throws Exception {
        File[] f;

        f = mostrarYObtenerSelectorArchivos();

        int i;

        try {
            //creamos el socket con la dirección y el puerto de comunicación
            Socket cl = new Socket(InetAddress.getByName("127.0.0.1"), 4000);
            cl.setSoTimeout(3000);
            System.out.println("Cliente conectado con servidor..\n transfiriendo archivo..");

            ObjectOutputStream oos = new ObjectOutputStream(cl.getOutputStream());
            
            oos.writeObject(f.length);

            for (i = 0; i < f.length; i++) {
                EnviarArchivo(f[i].getAbsolutePath(), f[i].getName(), f[i].length(), oos);
            }

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//main

    public static File[] mostrarYObtenerSelectorArchivos() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        File[] f = null;
        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            f = fileChooser.getSelectedFiles();

        }
        return f;
    }

    public static void EnviarArchivo(String path, String nombreArchivo, long tam, ObjectOutputStream oos) throws Exception {

        try {

            //creamos el archivo que vamos a enviar
            FileInputStream archivo = new FileInputStream(path);
            System.out.println("\nArchivo seleccionado: " + nombreArchivo);
            //Enviamos el nombre del archivo
            oos.writeObject(nombreArchivo);
            //Enviamos el direccion del archivo
            oos.writeObject(path);
            //Enviamos el tamaño del archivo
            oos.writeObject(tam);
            byte[] buf2 = new byte[1024];
            //enviamos los bytes del archivo

            int b_leidos = 0, tam_bloque;

            long completados = 0, leidos = 0;

            System.out.println("Tamaño archivo: " + archivo.available() + " bytes..");

            tam_bloque = (archivo.available() >= 1024) ? 1024 : archivo.available();
            long tam_arch = archivo.available();

            while ((b_leidos = archivo.read(buf2, 0, buf2.length)) != -1) {
                oos.write(buf2, 0, b_leidos);
                oos.flush();
                leidos += tam_bloque;
                completados = (leidos * 100) / tam_arch;
                System.out.print("\rCompletado: " + completados + " %");
                tam_bloque = (archivo.available() >= 1024) ? 1024 : archivo.available();
            }
            System.out.println("\nBytes envia
            while ((fin > 0) && (b_leidos = ois.read(buf, 0, (int) Math.min(buf.length, fin))) != -1) {

                inFile.write(buf, 0, b_leidos);
                inFile.flush();
                leidos += b_leidos;
                fin -= b_leidos;dos: " + leidos + "\n");
            //cerramos socket y flujos
            archivo.close();
            System.out.println("Archivo enviado....");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}//class
