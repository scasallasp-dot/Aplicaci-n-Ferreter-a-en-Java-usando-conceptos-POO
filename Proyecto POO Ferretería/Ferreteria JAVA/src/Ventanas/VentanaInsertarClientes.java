
package Ventanas;

import java.sql.Connection;
import conexiones.Conexiones;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VentanaInsertarClientes extends javax.swing.JFrame {

    public VentanaInsertarClientes() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l_titulo_ventana = new javax.swing.JLabel();
        l_nombre = new javax.swing.JLabel();
        l_direccion = new javax.swing.JLabel();
        l_telefono = new javax.swing.JLabel();
        t_nombre = new javax.swing.JTextField();
        t_direccion = new javax.swing.JTextField();
        t_telefono = new javax.swing.JTextField();
        b_insertar = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();
        l_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insertar Clientes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l_titulo_ventana.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        l_titulo_ventana.setForeground(new java.awt.Color(242, 242, 242));
        l_titulo_ventana.setText("Insertar Cliente");
        getContentPane().add(l_titulo_ventana, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        l_nombre.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        l_nombre.setForeground(new java.awt.Color(242, 242, 242));
        l_nombre.setText("Nombre:");
        getContentPane().add(l_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

        l_direccion.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        l_direccion.setForeground(new java.awt.Color(242, 242, 242));
        l_direccion.setText("Direccion:");
        getContentPane().add(l_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        l_telefono.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        l_telefono.setForeground(new java.awt.Color(242, 242, 242));
        l_telefono.setText("Teléfono:");
        getContentPane().add(l_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        t_nombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        t_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(t_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 180, 30));

        t_direccion.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        getContentPane().add(t_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 180, 30));

        t_telefono.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        t_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_telefonoActionPerformed(evt);
            }
        });
        getContentPane().add(t_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 180, 30));

        b_insertar.setBackground(new java.awt.Color(153, 255, 255));
        b_insertar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        b_insertar.setText("Insertar");
        b_insertar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_insertarActionPerformed(evt);
            }
        });
        getContentPane().add(b_insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 130, 50));

        b_cancelar.setBackground(new java.awt.Color(153, 255, 255));
        b_cancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        b_cancelar.setText("Cancelar");
        b_cancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(b_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 130, 50));

        l_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Gemini_Generated_Image_jvod7ujvod7ujvod.png"))); // NOI18N
        getContentPane().add(l_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 403));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nombreActionPerformed

    private void t_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_telefonoActionPerformed

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelarActionPerformed
        VentanaClientes menu = new VentanaClientes(); // Instancias la ventana a la que vas
        menu.setVisible(true);                    // La haces visible
        this.dispose();
    }//GEN-LAST:event_b_cancelarActionPerformed

    private void b_insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_insertarActionPerformed
        String nombre = t_nombre.getText().trim();
        String direccion = t_direccion.getText().trim();
        String telefono = t_telefono.getText().trim();
        
        Conexiones conexion = new Conexiones();
        Connection con = conexion.conectar();
        
        String sql ="insert into clientes (nombre, direccion, telefono) values (?,?,?)";
        if(nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty()){
            JOptionPane.showMessageDialog(null,"Debes llenar todos los campos", "Alerta",
                                            JOptionPane.WARNING_MESSAGE);
            return;
        }
        try{
            PreparedStatement insertar = con.prepareStatement(sql);
            insertar.setString(1, nombre);
            insertar.setString(2, direccion);
            insertar.setString(3, telefono);
            
            int resultado = insertar.executeUpdate();
            if(resultado > 0){
                JOptionPane.showMessageDialog(null, "Cliente insetado correctamente ", "Aviso",
                                                    JOptionPane.INFORMATION_MESSAGE);
                
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en el Insert " , "Alerta", 
                                            JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_b_insertarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaInsertarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cancelar;
    private javax.swing.JButton b_insertar;
    private javax.swing.JLabel l_direccion;
    private javax.swing.JLabel l_fondo;
    private javax.swing.JLabel l_nombre;
    private javax.swing.JLabel l_telefono;
    private javax.swing.JLabel l_titulo_ventana;
    private javax.swing.JTextField t_direccion;
    private javax.swing.JTextField t_nombre;
    private javax.swing.JTextField t_telefono;
    // End of variables declaration//GEN-END:variables
}
