/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.escom.resdes.ui.client;

import org.escom.resdes.ui.admin.AdminUI;
import org.escom.resdes.ui.admin.ProductoFormUI;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.escom.resdes.app.config.Propiedades;
import org.escom.resdes.app.service.StoreService;
import org.escom.resdes.app.service.StoreServiceImp;
import org.escom.resdes.model.Catalogo;
import org.escom.resdes.model.Producto;
import org.escom.resdes.repository.ProductoRepository;
import org.escom.resdes.repository.ProductoRepositoryImp;

/**
 *
 * @author darcusfenix
 */
public class StoreUI extends javax.swing.JFrame {

    private ProductoRepository pr;
    private StoreService ss;

    /**
     * Creates new form ServerAdmin
     */
    public StoreUI() {
        initComponents();
        pr = new ProductoRepositoryImp();
        ss = new StoreServiceImp();
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

        btn_add_producto_client = new javax.swing.JButton();
        btn_show_producto_client = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_productos_client = new javax.swing.JTable();
        btn_update_list_client = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Store");

        btn_add_producto_client.setText("AGREGAR A CESTA");
        btn_add_producto_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_producto_clientActionPerformed(evt);
            }
        });

        btn_show_producto_client.setText("MIRAR PRODUCTO");
        btn_show_producto_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_show_producto_clientActionPerformed(evt);
            }
        });

        table_productos_client.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_productos_client);

        btn_update_list_client.setText("ACTUALIZAR LISTA");
        btn_update_list_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update_list_clientActionPerformed(evt);
            }
        });

        jButton1.setText("MIRAR MI CESTA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_show_producto_client, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_add_producto_client, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_update_list_client, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_add_producto_client)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_show_producto_client)
                        .addGap(27, 27, 27)
                        .addComponent(btn_update_list_client)
                        .addGap(33, 33, 33)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_show_producto_clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_show_producto_clientActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Integer index = table_productos_client.getSelectedRow();
                if (index >= 0) {
                    DefaultTableModel model = (DefaultTableModel) table_productos_client.getModel();
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

    }//GEN-LAST:event_btn_show_producto_clientActionPerformed

    private void btn_add_producto_clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_producto_clientActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductoFormUI(Propiedades.REGISTRAR).setVisible(true);
            }
        });
    }//GEN-LAST:event_btn_add_producto_clientActionPerformed

    private void btn_update_list_clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update_list_clientActionPerformed
        updateTable();
    }//GEN-LAST:event_btn_update_list_clientActionPerformed

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
        Catalogo catalogo = null;
        catalogo = ss.getCatalogo();
        if (catalogo != null) {
            List<Producto> productos = catalogo.getProductos();
            DefaultTableModel model = (DefaultTableModel) table_productos_client.getModel();
            int rowCount = model.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            for (Producto producto : productos) {
                Object[] row = {producto.getSku(), producto.getNombre(), producto.getDescripcion(), producto.getUrlImagen(), producto.getCosto(), producto.getCantidad()};
                model.addRow(row);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_producto_client;
    private javax.swing.JButton btn_show_producto_client;
    private javax.swing.JButton btn_update_list_client;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_productos_client;
    // End of variables declaration//GEN-END:variables
}
