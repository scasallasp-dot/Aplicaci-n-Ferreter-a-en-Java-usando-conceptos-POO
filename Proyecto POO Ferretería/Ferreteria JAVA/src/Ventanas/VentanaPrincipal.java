
package Ventanas;

public class VentanaPrincipal extends javax.swing.JFrame {

    public VentanaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l_logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        b_clientes = new javax.swing.JButton();
        b_productos = new javax.swing.JButton();
        b_ventas = new javax.swing.JButton();
        b_volver = new javax.swing.JButton();
        b_salir = new javax.swing.JButton();
        l_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Principal");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ferreteria_200x200.png"))); // NOI18N
        getContentPane().add(l_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 180));

        jLabel1.setFont(new java.awt.Font("Wide Latin", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Modulo administración");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 500, 40));

        b_clientes.setBackground(new java.awt.Color(204, 255, 255));
        b_clientes.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        b_clientes.setText("Clientes");
        b_clientes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_clientesActionPerformed(evt);
            }
        });
        getContentPane().add(b_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 130, 60));

        b_productos.setBackground(new java.awt.Color(204, 255, 255));
        b_productos.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        b_productos.setText("Productos");
        b_productos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_productosActionPerformed(evt);
            }
        });
        getContentPane().add(b_productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 130, 60));

        b_ventas.setBackground(new java.awt.Color(204, 255, 255));
        b_ventas.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        b_ventas.setText("Ventas");
        b_ventas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ventasActionPerformed(evt);
            }
        });
        getContentPane().add(b_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 130, 60));

        b_volver.setBackground(new java.awt.Color(102, 255, 255));
        b_volver.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        b_volver.setText("Volver");
        b_volver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_volverActionPerformed(evt);
            }
        });
        getContentPane().add(b_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 120, 40));

        b_salir.setBackground(new java.awt.Color(102, 255, 255));
        b_salir.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        b_salir.setText("Salir");
        b_salir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_salirActionPerformed(evt);
            }
        });
        getContentPane().add(b_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 120, 40));

        l_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Gemini_Generated_Image_rzz69przz69przz6.png"))); // NOI18N
        l_fondo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(l_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_clientesActionPerformed
       dispose();
        new VentanaClientes().setVisible(true);
    }//GEN-LAST:event_b_clientesActionPerformed

    private void b_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_salirActionPerformed
        VentanaLogin menu = new VentanaLogin(); 
        menu.setVisible(true);                    
        this.dispose();
    }//GEN-LAST:event_b_salirActionPerformed

    private void b_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_volverActionPerformed
        VentanaPrincipal menu = new VentanaPrincipal(); 
        menu.setVisible(true);                    
        this.dispose();
    }//GEN-LAST:event_b_volverActionPerformed

    private void b_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ventasActionPerformed
        dispose();
        new VentanaVentas().setVisible(true);
    }//GEN-LAST:event_b_ventasActionPerformed

    private void b_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_productosActionPerformed
        dispose();
        new VentanaProductos().setVisible(true);
    }//GEN-LAST:event_b_productosActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_clientes;
    private javax.swing.JButton b_productos;
    private javax.swing.JButton b_salir;
    private javax.swing.JButton b_ventas;
    private javax.swing.JButton b_volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel l_fondo;
    private javax.swing.JLabel l_logo;
    // End of variables declaration//GEN-END:variables
}
