    
package Ventanas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import conexiones.Conexiones;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class VentanaLogin extends javax.swing.JFrame {

    public VentanaLogin() {
        initComponents();
        setLocationRelativeTo(null); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l_logo = new javax.swing.JLabel();
        l_usuario = new javax.swing.JLabel();
        l_pass = new javax.swing.JLabel();
        campo_pass = new javax.swing.JPasswordField();
        campo_usuario = new javax.swing.JTextField();
        b_acceder = new javax.swing.JButton();
        b_salir = new javax.swing.JButton();
        l_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Usuario");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ferreteria_200x200.png"))); // NOI18N
        getContentPane().add(l_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 200, 180));

        l_usuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        l_usuario.setText("Ingrese Usuario");
        getContentPane().add(l_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        l_pass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        l_pass.setText("Ingrese Constraseña");
        getContentPane().add(l_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        campo_pass.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        campo_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_passActionPerformed(evt);
            }
        });
        getContentPane().add(campo_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 150, 30));

        campo_usuario.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        campo_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_usuarioActionPerformed(evt);
            }
        });
        getContentPane().add(campo_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 150, 30));

        b_acceder.setBackground(new java.awt.Color(204, 255, 255));
        b_acceder.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        b_acceder.setText("Acceder");
        b_acceder.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_accederActionPerformed(evt);
            }
        });
        getContentPane().add(b_acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 130, 50));

        b_salir.setBackground(new java.awt.Color(204, 255, 255));
        b_salir.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        b_salir.setText("Salir");
        b_salir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_salirActionPerformed(evt);
            }
        });
        getContentPane().add(b_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 130, 50));

        l_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Gemini_Generated_Image_efn97pefn97pefn9.png"))); // NOI18N
        l_fondo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(l_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campo_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_usuarioActionPerformed

    private void b_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_salirActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Confirma salir de la aplicación ", 
                                                        "Confirmar salida ",
                                                        JOptionPane.YES_NO_OPTION,
                                                        JOptionPane.QUESTION_MESSAGE);  
        if(respuesta == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_b_salirActionPerformed
    int intentos = 0;
    private void b_accederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_accederActionPerformed
        Connection conexion = Conexiones.conectar();   
        String usuario = campo_usuario.getText();
        String clave = new String(campo_pass.getPassword());
        PreparedStatement consulta; 
        ResultSet resultado;
        int control = 0;
        try{
            String sql = "select * from usuarios where nombre_usuario = ? and clave = ?";
            consulta = conexion.prepareStatement(sql);
            consulta.setString(1, usuario);
            consulta.setString(2, clave);
            resultado = consulta.executeQuery();
            
            if(campo_usuario.getText().isEmpty() || new String(campo_pass.getPassword()).isEmpty()){
                JOptionPane.showMessageDialog(null,"No debe haber campos vacíos", "ERROR",
                                                JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if(resultado.next()){
                JOptionPane.showMessageDialog(null,"Loging Correcto", "LOGIN", 
                                                JOptionPane.INFORMATION_MESSAGE);
                VentanaPrincipal principal = new VentanaPrincipal(); // Instancias tu ventana principal
                principal.setVisible(true);                         // La haces visible
                this.dispose();
            }else{
                intentos++;
                JOptionPane.showMessageDialog(null, "Usuario/Contraseña incorrectos " + "Intente de nuevo", "ERROR",
                                                JOptionPane.ERROR_MESSAGE);
                campo_usuario.setText("");
                campo_pass.setText("");
            }
            if(intentos==3){
                JOptionPane.showMessageDialog(null,"Cantidad de intentos agotada "+ "Su cuenta ha sido bloqueada "+
                                                "Contacte a soporte", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_b_accederActionPerformed

    private void campo_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_passActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_acceder;
    private javax.swing.JButton b_salir;
    private javax.swing.JPasswordField campo_pass;
    private javax.swing.JTextField campo_usuario;
    private javax.swing.JLabel l_fondo;
    private javax.swing.JLabel l_logo;
    private javax.swing.JLabel l_pass;
    private javax.swing.JLabel l_usuario;
    // End of variables declaration//GEN-END:variables
}
