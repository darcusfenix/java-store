/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.escom.resdes.ui;

import org.escom.resdes.app.config.Propiedades;
import org.escom.resdes.model.Producto;
import org.escom.resdes.repository.ProductoRepository;
import org.escom.resdes.repository.ProductoRepositoryImp;

/**
 *
 * @author darcusfenix
 */
public class ProductoFormUI extends javax.swing.JFrame {
    private Integer action;
    private ProductoRepository pr;
    private Producto producto;
    /**
     * Creates new form ProductoForm
     */
    public ProductoFormUI() {
        initComponents();
    }
    public ProductoFormUI(Producto producto, Integer action) {
        initComponents();
        this.producto = producto;
        this.action = action;
        pr = new ProductoRepositoryImp();
        updateTexFields();
        btn_edit_save_producto.setText("ACTUALIZAR PRODUCTO");
    }
    public ProductoFormUI(Integer action) {
        initComponents();
        this.action = action;
        this.producto = new Producto();
        pr = new ProductoRepositoryImp();
        btn_edit_save_producto.setText("AGREGAR PRODUCTO");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_desc_producto = new javax.swing.JTextField();
        tf_nombre_producto = new javax.swing.JTextField();
        tf_img_producto = new javax.swing.JTextField();
        btn_edit_save_producto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tf_costo_producto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_cantidad_producto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Producto");

        jLabel1.setText("NOMBRE:");

        jLabel2.setText("DESCRIPCION:");

        jLabel3.setText("IMAGEN:");

        tf_desc_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_desc_productoActionPerformed(evt);
            }
        });

        tf_nombre_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nombre_productoActionPerformed(evt);
            }
        });

        tf_img_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_img_productoActionPerformed(evt);
            }
        });

        btn_edit_save_producto.setText("info");
        btn_edit_save_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_save_productoActionPerformed(evt);
            }
        });

        jLabel4.setText("COSTO:");

        tf_costo_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_costo_productoActionPerformed(evt);
            }
        });

        jLabel5.setText("CANTIDAD:");

        tf_cantidad_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cantidad_productoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_edit_save_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(40, 40, 40)
                                .addComponent(tf_nombre_producto, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_desc_producto))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_costo_producto)
                                    .addComponent(tf_img_producto)
                                    .addComponent(tf_cantidad_producto))))
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tf_nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tf_desc_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tf_img_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tf_costo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5))
                    .addComponent(tf_cantidad_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_edit_save_producto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_desc_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_desc_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_desc_productoActionPerformed

    private void tf_nombre_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nombre_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nombre_productoActionPerformed

    private void tf_img_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_img_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_img_productoActionPerformed

    private void btn_edit_save_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_save_productoActionPerformed
        
        if (tf_nombre_producto != null 
                && tf_desc_producto != null 
                && tf_img_producto != null 
                && tf_costo_producto != null
                && tf_cantidad_producto != null) {
            
            producto.setNombre(tf_nombre_producto.getText());
            producto.setDescripcion(tf_desc_producto.getText());
            producto.setUrlImagen(tf_img_producto.getText());
            producto.setCosto(Float.parseFloat(tf_costo_producto.getText()));
            producto.setCantidad(Integer.parseInt(tf_cantidad_producto.getText()));
        }else{
            return;
        }
        
        if (action == Propiedades.EDITAR) {
            pr.update(producto);
        }
        if (action == Propiedades.REGISTRAR){
            pr.save(producto);
        }
        this.dispose();
    }//GEN-LAST:event_btn_edit_save_productoActionPerformed

    private void tf_costo_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_costo_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_costo_productoActionPerformed

    private void tf_cantidad_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cantidad_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cantidad_productoActionPerformed

    public void updateTexFields(){
        tf_desc_producto.setText(this.producto.getDescripcion());
        tf_nombre_producto.setText(this.producto.getNombre());
        tf_img_producto.setText(this.producto.getUrlImagen());
        tf_costo_producto.setText(Float.toString(this.producto.getCosto()));
        tf_cantidad_producto.setText(Integer.toString(this.producto.getCantidad()));
    }
    
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
            java.util.logging.Logger.getLogger(ProductoFormUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductoFormUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductoFormUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductoFormUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductoFormUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit_save_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tf_cantidad_producto;
    private javax.swing.JTextField tf_costo_producto;
    private javax.swing.JTextField tf_desc_producto;
    private javax.swing.JTextField tf_img_producto;
    private javax.swing.JTextField tf_nombre_producto;
    // End of variables declaration//GEN-END:variables
}