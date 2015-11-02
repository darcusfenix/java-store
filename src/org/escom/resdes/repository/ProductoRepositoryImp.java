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
package org.escom.resdes.repository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.escom.resdes.app.config.Propiedades;
import org.escom.resdes.jdbc.PostgreSQLJDBC;
import org.escom.resdes.model.Producto;

/**
 *
 * @author darcusfenix
 */
public class ProductoRepositoryImp implements ProductoRepository {

    @Override
    public List<Producto> getAll() {
        List<Producto> productos = new ArrayList<Producto>();

        PostgreSQLJDBC bC = new PostgreSQLJDBC();
        if (bC.conectarse()) {
            Connection connection = bC.getConnection();
            Statement stmt = null;
            String stm = "SELECT * FROM producto;";
            try {
                stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(stm);

                while (rs.next()) {
                    Producto producto = new Producto();
                    producto.setSku(rs.getInt("sku"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setUrlImagen(rs.getString("url_imagen"));
                    producto.setCosto(rs.getFloat("costo"));
                    producto.setCantidad(rs.getInt("cantidad"));
                    productos.add(producto);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } finally {

                try {
                    if (stmt != null) {
                        stmt.close();
                    }

                    if (connection != null) {
                        connection.close();
                    }

                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }

        return productos;
    }

    @Override
    public void saveCatalogoOnServer() {
        List<Producto> productos = new ArrayList<Producto>();

        PostgreSQLJDBC bC = new PostgreSQLJDBC();
        if (bC.conectarse()) {
            Connection connection = bC.getConnection();
            Statement stmt = null;
            String stm = "SELECT * FROM producto;";
            try {
                stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(stm);

                while (rs.next()) {
                    Producto producto = new Producto();
                    producto.setSku(rs.getInt("sku"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setUrlImagen(rs.getString("url_imagen"));
                    producto.setCosto(rs.getFloat("costo"));
                    producto.setCantidad(rs.getInt("cantidad"));
                    productos.add(producto);
                }
                try {
                    FileOutputStream fileOut = new FileOutputStream(Propiedades.PATH + "PATH_SERVER/CATALOGO/catalogo.txt");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(productos);
                    out.close();
                    fileOut.close();
                } catch (IOException io) {
                    System.err.println(io.getMessage());
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } finally {

                try {
                    if (stmt != null) {
                        stmt.close();
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

    @Override
    public void save(Producto producto) {
        PostgreSQLJDBC bC = new PostgreSQLJDBC();
        if (bC.conectarse()) {
            Connection connection = bC.getConnection();
            PreparedStatement pst = null;
            String stm = "INSERT INTO producto(nombre, descripcion, url_imagen, costo, cantidad) VALUES(?, ?, ?, ?, ?)";
            try {
                pst = connection.prepareStatement(stm);
                pst.setString(1, producto.getNombre());
                pst.setString(2, producto.getDescripcion());
                pst.setString(3, producto.getUrlImagen());
                pst.setFloat(4, producto.getCosto());
                pst.setInt(5, producto.getCantidad());
                pst.executeQuery();
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

    @Override
    public void update(Producto producto) {
        PostgreSQLJDBC bC = new PostgreSQLJDBC();
        if (bC.conectarse()) {
            Connection connection = bC.getConnection();
            PreparedStatement pst = null;
            String stm = "UPDATE producto SET nombre=?, descripcion=?, url_imagen=?, costo=?, cantidad=? WHERE sku=?;";
            try {
                pst = connection.prepareStatement(stm);
                pst.setString(1, producto.getNombre());
                pst.setString(2, producto.getDescripcion());
                pst.setString(3, producto.getUrlImagen());
                pst.setFloat(4, producto.getCosto());
                pst.setInt(5, producto.getCantidad());
                pst.setInt(6, producto.getSku());
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

    @Override
    public void delete(Producto producto) {
        PostgreSQLJDBC bC = new PostgreSQLJDBC();
        if (bC.conectarse()) {
            Connection connection = bC.getConnection();
            PreparedStatement pst = null;
            String stm = "DELETE FROM producto WHERE sku=?;";
            try {
                pst = connection.prepareStatement(stm);
                pst.setInt(1, producto.getSku());
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

    @Override
    public Producto getById(Integer sku) {
        Producto producto = new Producto();
        PostgreSQLJDBC bC = new PostgreSQLJDBC();
        if (bC.conectarse()) {
            Connection connection = bC.getConnection();
            Statement stmt = null;
            String stm = "SELECT * FROM producto WHERE sku =" + sku + " ;";
            try {
                stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);;
                ResultSet rs = stmt.executeQuery(stm);
                if (rs.first()) {
                    producto.setSku(rs.getInt("sku"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setUrlImagen(rs.getString("url_imagen"));
                    producto.setCosto(rs.getFloat("costo"));
                    producto.setCantidad(rs.getInt("cantidad"));
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } finally {

                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }

                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
        return producto;
    }
}
