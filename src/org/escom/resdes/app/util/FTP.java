/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.escom.resdes.app.util;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author darcusfenix
 */
public interface FTP {

    void recibeArchivo(ObjectInputStream ois, String path) throws IOException, ClassNotFoundException;

    void enviarArchivo(String path, String nombreArchivo, long tam, ObjectOutputStream oos) throws Exception;
    File[] selectFilesWithChooser();
    File[] selectFilesWithPath(String path);
}
