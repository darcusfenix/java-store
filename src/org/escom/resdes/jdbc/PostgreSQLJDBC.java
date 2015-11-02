/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.escom.resdes.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.escom.resdes.app.config.Propiedades;

/**
 *
 * @author darcusfenix
 */
public class PostgreSQLJDBC {

    private Connection connection;

    public PostgreSQLJDBC() {
        this.connection = null;
    }

    public boolean conectarse() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager
                    .getConnection("jdbc:postgresql://"+Propiedades.IP+":5432/store",
                            "postgres", "2706");
            return true;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    // probando conexión e INSERT de un producto
    public static void main(String args[]) {
        PostgreSQLJDBC bC = new PostgreSQLJDBC();
        if (bC.conectarse()) {
            Connection connection = bC.getConnection();
            PreparedStatement pst = null;
            String stm = "INSERT INTO producto(nombre, descripcion, url_imagen) VALUES(?, ?, ?)";
            try {
                pst = connection.prepareStatement(stm);
                pst.setString(1, "LAPTOP MACBOOK PRO 13 PULGADAS 8 GB 512 APPLE");
                pst.setString(2, "Una innovadora pantalla Retina, un nuevo trackpad sensible a la presión. Arquitectura en flash. Potentes procesadores Intel. ");
                pst.setString(3, "/home/darcusfenix/Documentos/ESCOM/REDES-APPS/P2/imagenes");
                pst.executeUpdate();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } finally {

                try {
                    if (pst != null) {
                        pst.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }

                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }
}
/*

 CREATE TABLE producto (
 sku         serial PRIMARY KEY ,
 nombre      varchar(255) NOT NULL,
 descripcion varchar(255) NOT NULL,
 url_imagen  varchar(255) NOT NULL,
 costo float NOT NULL
 );

 */
