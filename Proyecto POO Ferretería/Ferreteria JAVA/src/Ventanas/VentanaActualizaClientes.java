
package Ventanas;


import java.sql.Connection;
import conexiones.Conexiones;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class VentanaActualizaClientes extends javax.swing.JFrame {

    public VentanaActualizaClientes() {
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
        b_actualizar = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();
        l_id_cliente = new javax.swing.JLabel();
        t_id_cliente = new javax.swing.JTextField();
        b_buscar = new javax.swing.JButton();
        l_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insertar Clientes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l_titulo_ventana.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        l_titulo_ventana.setForeground(new java.awt.Color(242, 242, 242));
        l_titulo_ventana.setText("Actualizar Cliente");
        getContentPane().add(l_titulo_ventana, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        l_nombre.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        l_nombre.setForeground(new java.awt.Color(242, 242, 242));
        l_nombre.setText("Nombre:");
        getContentPane().add(l_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

        l_direccion.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        l_direccion.setForeground(new java.awt.Color(242, 242, 242));
        l_direccion.setText("Direccion:");
        getContentPane().add(l_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        l_telefono.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        l_telefono.setForeground(new java.awt.Color(242, 242, 242));
        l_telefono.setText("Teléfono:");
        getContentPane().add(l_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        t_nombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        t_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(t_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 180, 30));

        t_direccion.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        getContentPane().add(t_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 180, 30));

        t_telefono.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        t_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_telefonoActionPerformed(evt);
            }
        });
        getContentPane().add(t_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 180, 30));

        b_actualizar.setBackground(new java.awt.Color(153, 255, 255));
        b_actualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        b_actualizar.setText("Actualizar");
        b_actualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(b_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 130, 50));

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

        l_id_cliente.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        l_id_cliente.setForeground(new java.awt.Color(242, 242, 242));
        l_id_cliente.setText("Id Cliente:");
        getContentPane().add(l_id_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));

        t_id_cliente.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        t_id_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_id_clienteActionPerformed(evt);
            }
        });
        getContentPane().add(t_id_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 70, 30));

        b_buscar.setBackground(new java.awt.Color(153, 255, 255));
        b_buscar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        b_buscar.setText("Buscar");
        b_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(b_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

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
        VentanaClientes menu = new VentanaClientes(); 
        menu.setVisible(true);                    
        this.dispose();
    }//GEN-LAST:event_b_cancelarActionPerformed

    private void b_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_actualizarActionPerformed
        String idCliente = t_id_cliente.getText().trim();
        String nombre = t_nombre.getText().trim();
        String direccion = t_direccion.getText().trim();
        String telefono = t_telefono.getText().trim();
        
        if(idCliente.isEmpty() || nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty()){
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos ", "Alerta",
                                            JOptionPane.WARNING_MESSAGE);
            return;
        }
        Conexiones conexion = new Conexiones();
        Connection con = conexion.conectar();
        
        String verificaCliente = "select count(*) from clientes where id_cliente =? " ;
        String actualizar = "update clientes set nombre =?, direccion =?, telefono =? where id_cliente =?";
        
        try{
            PreparedStatement verificar = con.prepareStatement(verificaCliente);
            verificar.setInt(1,Integer.parseInt(idCliente));
            ResultSet resultado = verificar.executeQuery();
            resultado.next();
            int existe = resultado.getInt(1);
            
            if(existe>0){
                try{
                    PreparedStatement p_actualizar = con.prepareStatement(actualizar);
                    p_actualizar.setString(1, nombre);
                    p_actualizar.setString(2, direccion);
                    p_actualizar.setString(3, telefono);
                    p_actualizar.setInt(4, Integer.parseInt(idCliente));
                    int actualizacion = p_actualizar.executeUpdate();
                    
                    if(actualizacion>0){
                        JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente");
                        t_nombre.setText("");
                        t_direccion.setText("");
                        t_telefono.setText("");
                        t_id_cliente.setText("");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error actualizando Cliente", "Error",
                                                       JOptionPane.ERROR_MESSAGE);
                    }
                    
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Error actualizando Cliente", "Aviso",
                                                    JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error actualizando Cliente", "Aviso",
                                                    JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        
    }//GEN-LAST:event_b_actualizarActionPerformed

    private void t_id_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_id_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_id_clienteActionPerformed

    private void b_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_buscarActionPerformed
        String idCliente = t_id_cliente.getText().trim();
    
    if(idCliente.isEmpty()){
        JOptionPane.showMessageDialog(null, "Debe colocar un ID de cliente", "Alerta",
                                        JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    String sql = "SELECT nombre, direccion, telefono FROM clientes WHERE id_cliente = ?";
    Conexiones conexion = new Conexiones();
    Connection con = null;
    
    try {
        con = conexion.conectar();
        PreparedStatement consulta = con.prepareStatement(sql);
       
        try {
            consulta.setInt(1, Integer.parseInt(idCliente));
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        
        ResultSet resultado = consulta.executeQuery(); 
        
        if(resultado.next()){
            t_nombre.setText(resultado.getString("nombre"));
            t_direccion.setText(resultado.getString("direccion"));
            t_telefono.setText(resultado.getString("telefono"));
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            t_nombre.setText("");
            t_direccion.setText("");
            t_telefono.setText("");
        }
        
    } catch(SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (con != null) con.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar conexión: " + ex.getMessage());
        }
    }
        
        
        
        
        
    }//GEN-LAST:event_b_buscarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaActualizaClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_actualizar;
    private javax.swing.JButton b_buscar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JLabel l_direccion;
    private javax.swing.JLabel l_fondo;
    private javax.swing.JLabel l_id_cliente;
    private javax.swing.JLabel l_nombre;
    private javax.swing.JLabel l_telefono;
    private javax.swing.JLabel l_titulo_ventana;
    private javax.swing.JTextField t_direccion;
    private javax.swing.JTextField t_id_cliente;
    private javax.swing.JTextField t_nombre;
    private javax.swing.JTextField t_telefono;
    // End of variables declaration//GEN-END:variables
}
