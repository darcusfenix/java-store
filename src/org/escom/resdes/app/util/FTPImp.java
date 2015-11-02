/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.escom.resdes.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import org.escom.resdes.app.config.Propiedades;

/**
 *
 * @author darcusfenix
 */
public class FTPImp implements FTP {
    @Override
    public void recibeArchivo(ObjectInputStream ois, String pathUser) throws IOException, ClassNotFoundException {

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
            byte[] buf = new byte[2024];
            //obtenemos el archivo
            long leidos = 0, fin = tam, po = 0;
            int b_leidos = 0;
            //creamos el archivo que vamos a recibir, y lo ubicamos en la carpeta del proyecto
            FileOutputStream inFile = new FileOutputStream(Propiedades.PATH_CLIENTE + pathUser + "/" + nombre);

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
    @Override
    public void enviarArchivo(String path, String nombreArchivo, long tam, ObjectOutputStream oos) throws Exception {

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
            System.out.println("\nBytes enviados: " + leidos + "\n");
            //cerramos socket y flujos
            archivo.close();
            System.out.println("Archivo enviado....");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public File[] selectFilesWithChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        File[] f = null;
        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            f = fileChooser.getSelectedFiles();

        }
        return f;
    }
    @Override
    public File[] selectFilesWithPath(String path) {
        File[] f = null;
        f = new File(path).listFiles();
        return f;
    }
}
