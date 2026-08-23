
package Ventanas;


import java.sql.Connection;
import conexiones.Conexiones;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class VentanaBorrarClientes extends javax.swing.JFrame {

    public VentanaBorrarClientes() {
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
        b_borrar = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();
        l_id_cliente = new javax.swing.JLabel();
        t_id_cliente = new javax.swing.JTextField();
        b_buscar = new javax.swing.JButton();
        l_nombreCliente = new javax.swing.JLabel();
        l_direccionCliente = new javax.swing.JLabel();
        l_telefonoCliente = new javax.swing.JLabel();
        l_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Borrar Clientes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l_titulo_ventana.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        l_titulo_ventana.setForeground(new java.awt.Color(242, 242, 242));
        l_titulo_ventana.setText("Borrar Cliente");
        getContentPane().add(l_titulo_ventana, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

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

        b_borrar.setBackground(new java.awt.Color(153, 255, 255));
        b_borrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        b_borrar.setText("Borrar");
        b_borrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_borrarActionPerformed(evt);
            }
        });
        getContentPane().add(b_borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 130, 50));

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

        l_nombreCliente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        l_nombreCliente.setForeground(new java.awt.Color(242, 242, 242));
        getContentPane().add(l_nombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        l_direccionCliente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        l_direccionCliente.setForeground(new java.awt.Color(242, 242, 242));
        getContentPane().add(l_direccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        l_telefonoCliente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        l_telefonoCliente.setForeground(new java.awt.Color(242, 242, 242));
        getContentPane().add(l_telefonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, -1));

        l_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Gemini_Generated_Image_jvod7ujvod7ujvod.png"))); // NOI18N
        getContentPane().add(l_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 403));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelarActionPerformed
        VentanaClientes menu = new VentanaClientes(); 
        menu.setVisible(true);                    
        this.dispose();
    }//GEN-LAST:event_b_cancelarActionPerformed

    private void b_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_borrarActionPerformed
        String idCliente = t_id_cliente.getText();
        try {
            Integer.parseInt(idCliente); // Pasar a entero string para validar
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe buscar cliente a borrar", "Alerta",
                    JOptionPane.WARNING_MESSAGE);
           
            return; 
        }
        
        String sql = "delete from clientes where id_cliente=?";
        Conexiones conexion = new Conexiones();
        Connection con = conexion.conectar();
        
        try{
            PreparedStatement ejecucion = con.prepareStatement(sql);
            ejecucion.setInt(1,Integer.parseInt(idCliente));
            int fila = ejecucion.executeUpdate();
            
            if(fila>0){
                JOptionPane.showMessageDialog(null, "Cliente Borrado", "Aviso",
                                                JOptionPane.INFORMATION_MESSAGE);
                l_nombreCliente.setText("");
                l_direccionCliente.setText("");
                l_telefonoCliente.setText("");
                t_id_cliente.setText("");
            }else{
            JOptionPane.showMessageDialog(null, "Clinete no existe", "Aviso",
                                            JOptionPane.INFORMATION_MESSAGE);
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error conectando a la base de datos ", "Error",
                                            JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_b_borrarActionPerformed

    private void t_id_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_id_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_id_clienteActionPerformed

    private void b_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_buscarActionPerformed
        String idCliente = t_id_cliente.getText();

        try {
            Integer.parseInt(idCliente); // Pasar a entero string para validar
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe colocar un valor entero", "Alerta",
                    JOptionPane.WARNING_MESSAGE);
            t_id_cliente.setText(""); // Se limpia el campo
            return; // CORRECCIÓN 1: Detiene la ejecución aquí para que no intente buscar en la BD
        }

        if (t_id_cliente.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo ID cliente vacío", "Alerta",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        String sql = "select nombre, direccion, telefono from clientes where id_cliente = ?";
        Conexiones conexion = new Conexiones();
        Connection con = conexion.conectar();

        try {
            PreparedStatement consulta = con.prepareStatement(sql);
            consulta.setString(1, idCliente);
            ResultSet resultado = consulta.executeQuery();

            if (resultado.next()) {
                // CORRECCIÓN 3: Extraer los datos reales del ResultSet usando resultado.getString(...)
                l_nombreCliente.setText(resultado.getString("nombre"));
                l_direccionCliente.setText(resultado.getString("direccion"));
                l_telefonoCliente.setText(resultado.getString("telefono"));
            } else {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Aviso",
                        JOptionPane.ERROR_MESSAGE);
                // Opcional: Limpiar las etiquetas si no se encuentra
                l_nombreCliente.setText("");
                l_direccionCliente.setText("");
                l_telefonoCliente.setText("");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE); // Cambiado a ERROR_MESSAGE para ser preciso
        }
    }//GEN-LAST:event_b_buscarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaBorrarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_borrar;
    private javax.swing.JButton b_buscar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JLabel l_direccion;
    private javax.swing.JLabel l_direccionCliente;
    private javax.swing.JLabel l_fondo;
    private javax.swing.JLabel l_id_cliente;
    private javax.swing.JLabel l_nombre;
    private javax.swing.JLabel l_nombreCliente;
    private javax.swing.JLabel l_telefono;
    private javax.swing.JLabel l_telefonoCliente;
    private javax.swing.JLabel l_titulo_ventana;
    private javax.swing.JTextField t_id_cliente;
    // End of variables declaration//GEN-END:variables
}
