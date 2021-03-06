/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.escom.resdes.ui.admin;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.escom.resdes.app.config.Propiedades;
import org.escom.resdes.model.Producto;
import org.escom.resdes.repository.ProductoRepository;
import org.escom.resdes.repository.ProductoRepositoryImp;

/**
 *
 * @author darcusfenix
 */
public class AdminUI extends javax.swing.JFrame {
    private ProductoRepository pr;

    /**
     * Creates new form ServerAdmin
     */
    public AdminUI() {
        initComponents();
        pr = new ProductoRepositoryImp();
        updateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_add_producto = new javax.swing.JButton();
        btn_del_producto = new javax.swing.JButton();
        btn_update_producto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_productos = new javax.swing.JTable();
        l_info_server = new javax.swing.JLabel();
        btn_update_list = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor Administrador");

        btn_add_producto.setText("AGREGAR PRODUCTO");
        btn_add_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_productoActionPerformed(evt);
            }
        });

        btn_del_producto.setText("ELIMINAR PRODUCTO");
        btn_del_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_del_productoActionPerformed(evt);
            }
        });

        btn_update_producto.setText("ACTUALIZAR PRODUCTO");
        btn_update_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update_productoActionPerformed(evt);
            }
        });

        table_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "sku", "nombre", "descripción", "imagen", "costo", "cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_productos);

        l_info_server.setText("INFO: ");

        btn_update_list.setText("ACTUALIZAR LISTA");
        btn_update_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update_listActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_update_producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_del_producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_add_producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_update_list, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(l_info_server)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_info_server)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_add_producto)
                        .addGap(18, 18, 18)
                        .addComponent(btn_del_producto)
                        .addGap(18, 18, 18)
                        .addComponent(btn_update_producto)
                        .addGap(26, 26, 26)
                        .addComponent(btn_update_list)))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_del_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_del_productoActionPerformed
        Integer index = table_productos.getSelectedRow();
        if (index >= 0) {
            DefaultTableModel model = (DefaultTableModel) table_productos.getModel();
            Producto producto = new Producto();
            producto.setSku((Integer) model.getValueAt(index, 0));
            pr.delete(producto);
            updateTable();
        }
    }//GEN-LAST:event_btn_del_productoActionPerformed

    private void btn_update_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update_productoActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Integer index = table_productos.getSelectedRow();
                if (index >= 0) {
                    DefaultTableModel model = (DefaultTableModel) table_productos.getModel();
                    Producto producto = new Producto();
                    producto.setSku((Integer) model.getValueAt(index, 0));
                    producto.setNombre((String) model.getValueAt(index, 1));
                    producto.setDescripcion((String) model.getValueAt(index, 2));
                    producto.setUrlImagen((String) model.getValueAt(index, 3));
                    producto.setCosto((Float) model.getValueAt(index, 4));
                    producto.setCantidad((Integer) model.getValueAt(index, 5));
                    new ProductoFormUI(producto, Propiedades.EDITAR).setVisible(true);
                }
            }
        });

    }//GEN-LAST:event_btn_update_productoActionPerformed

    private void btn_add_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_productoActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductoFormUI(Propiedades.REGISTRAR).setVisible(true);
            }
        });
    }//GEN-LAST:event_btn_add_productoActionPerformed

    private void btn_update_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update_listActionPerformed
        updateTable();
    }//GEN-LAST:event_btn_update_listActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUI().setVisible(true);
            }
        });
    }

    public void updateTable() {
        List<Producto> productos = pr.getAll();
        DefaultTableModel model = (DefaultTableModel) table_productos.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (Producto producto : productos) {
            Object[] row = {producto.getSku(), producto.getNombre(), producto.getDescripcion(), producto.getUrlImagen(), producto.getCosto(), producto.getCantidad()};
            model.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_producto;
    private javax.swing.JButton btn_del_producto;
    private javax.swing.JButton btn_update_list;
    private javax.swing.JButton btn_update_producto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_info_server;
    private javax.swing.JTable table_productos;
    // End of variables declaration//GEN-END:variables
}
