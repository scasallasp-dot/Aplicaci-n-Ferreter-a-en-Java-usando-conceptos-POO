
package Ventanas;
import com.mysql.cj.jdbc.JdbcPreparedStatement;
import javax.swing.JOptionPane;
import conexiones.Conexiones;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VentanaProductos extends javax.swing.JFrame {

    public VentanaProductos() {
    initComponents();
    setLocationRelativeTo(null);
    setResizable(false);
    Mostrar("productos");
}

Conexiones conexion = new Conexiones();
Connection con = conexion.conectar();

public void Mostrar(String tabla) {
    String sql = "select p.id_producto, p.nombre, p.descripcion, p.precio, p.existencia, c.nombre_categoria, p.fecha_ingreso " +
                 "from " + tabla + " p " + 
                 "join categorias c on p.id_categoria = c.id_categoria";

    DefaultTableModel modelo = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Id_producto", "Nombre", "Descripcion", "Precio", "Existencias", "Categoria", "Fecha Ingreso"}
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    tabla1.setModel(modelo);
    
    for (int f = 0; f < tabla1.getColumnCount(); f++) {
        tabla1.getColumnModel().getColumn(f).setResizable(true);
    }
    
    String[] datos = new String[7];
    
    try {
        Statement consulta = con.createStatement();
        ResultSet resultado = consulta.executeQuery(sql);
    
        while(resultado.next()){
            datos[0] = resultado.getString("id_producto"); 
            datos[1] = resultado.getString("nombre");
            datos[2] = resultado.getString("descripcion");
            datos[3] = resultado.getString("precio");
            datos[4] = resultado.getString("existencia");  
            datos[5] = resultado.getString("nombre_categoria");
            datos[6] = resultado.getString("fecha_ingreso");
           
            modelo.addRow(datos);
        }
    } catch(Exception e) {
       
        javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar productos: " + e.getMessage());
        e.printStackTrace();
    }
    
    centrarTexto(tabla1);
}
    public void centrarTexto(JTable tabla) {
    DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
    centrado.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
    for (int i = 0; i < tabla.getColumnCount(); i++) {
        tabla.getColumnModel().getColumn(i).setCellRenderer(centrado);
    }
}
    
    public void Buscar_Id_producto() {
        String idProducto = t_id_producto.getText();

        if (idProducto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese Id del cliente " + JOptionPane.WARNING_MESSAGE);
            return;
        }
        String sql = "select p.id_producto, p.nombre, p.descripcion, p.precio, p.existencia, c.nombre_categoria, p.fecha_ingreso "
                + "from productos p "
                + "join categorias c on p.id_categoria = c.id_categoria "
                + "where p.id_producto = ?";
        DefaultTableModel modelo = (DefaultTableModel) tabla1.getModel();
        modelo.setRowCount(0);

        try {
            Connection con = conexion.conectar();
            PreparedStatement consulta = con.prepareStatement(sql);
            consulta.setString(1, idProducto);
            ResultSet resultado = consulta.executeQuery();

            if (resultado.next()) {

                String[] datos = {
                    resultado.getString("id_producto"),
                    resultado.getString("nombre"),
                    resultado.getString("descripcion"),
                    resultado.getString("precio"),
                    resultado.getString("existencia"),
                    resultado.getString("nombre_categoria"),
                    resultado.getString("fecha_ingreso")
                };

                modelo.addRow(datos);
            } else {
                JOptionPane.showMessageDialog(null, "Producto no Existe ", "Resutado de busqueda",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void BuscarCategoria(){
        String NombreCategoria= t_categoria.getText();
        if(NombreCategoria.isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar Categoria de producto", "Aviso ", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String sql = "select p.id_producto, p.nombre, p.descripcion, p.precio, p.existencia, c.nombre_categoria, p.fecha_ingreso "
                + "from productos p "
                + "join categorias c on p.id_categoria = c.id_categoria "
                + "where c.nomnre_categoria like ?";
        DefaultTableModel modelo = (DefaultTableModel)tabla1.getModel();
        modelo.setRowCount(0);
        
        try{
            Connection con = conexion.conectar();
            PreparedStatement consulta = con.prepareStatement(sql);

            consulta.setString(1, "%"+NombreCategoria+"%");
            ResultSet resultado = consulta.executeQuery();
            
            boolean encontrado = false;

            while(resultado.next()) {

                String[] datos = {
                    resultado.getString("id_cliente"),
                    resultado.getString("nombre"),
                    resultado.getString("descripcion"),
                    resultado.getString("existencia"),
                    resultado.getString("nombre_categoria"),
                    resultado.getString("fecha_ingreso")
                };

                modelo.addRow(datos);
                encontrado = true; 
            } 
            if(!encontrado){
                JOptionPane.showMessageDialog(null, "Producto no Existe ", "Resutado de busqueda",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la busqueda", "Resultado",
                                            JOptionPane.ERROR_MESSAGE);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l_logo = new javax.swing.JLabel();
        b_administrar = new javax.swing.JButton();
        t_id_producto = new javax.swing.JTextField();
        t_categoria = new javax.swing.JTextField();
        l_idCliente = new javax.swing.JLabel();
        l_nombreCliente = new javax.swing.JLabel();
        b_buscar = new javax.swing.JButton();
        jscrollpane = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        b_volver = new javax.swing.JButton();
        b_salir = new javax.swing.JButton();
        l_modulo = new javax.swing.JLabel();
        l_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modulo Poductos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ferreteria_200x200.png"))); // NOI18N
        getContentPane().add(l_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 10, 190, 180));

        b_administrar.setBackground(new java.awt.Color(204, 255, 255));
        b_administrar.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        b_administrar.setText("Administrar");
        b_administrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_administrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_administrarActionPerformed(evt);
            }
        });
        getContentPane().add(b_administrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 240, 60));

        t_id_producto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t_id_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_id_productoActionPerformed(evt);
            }
        });
        getContentPane().add(t_id_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 90, 130, -1));

        t_categoria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_categoriaActionPerformed(evt);
            }
        });
        getContentPane().add(t_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 150, 130, 30));

        l_idCliente.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        l_idCliente.setForeground(new java.awt.Color(242, 242, 242));
        l_idCliente.setText("Id Producto");
        getContentPane().add(l_idCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 90, -1, -1));

        l_nombreCliente.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        l_nombreCliente.setForeground(new java.awt.Color(242, 242, 242));
        l_nombreCliente.setText("Categoria");
        getContentPane().add(l_nombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 160, -1, -1));

        b_buscar.setBackground(new java.awt.Color(204, 255, 255));
        b_buscar.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        b_buscar.setText("Buscar");
        b_buscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(b_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 90, 120, 90));

        tabla1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "nombre", "descripcion", "precio", "existencia", "id categoria", "fecha ingreso"
            }
        ));
        jscrollpane.setViewportView(tabla1);

        getContentPane().add(jscrollpane, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 1370, 290));

        b_volver.setBackground(new java.awt.Color(102, 255, 255));
        b_volver.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        b_volver.setText("Volver");
        b_volver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_volverActionPerformed(evt);
            }
        });
        getContentPane().add(b_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, 120, 40));

        b_salir.setBackground(new java.awt.Color(102, 255, 255));
        b_salir.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        b_salir.setText("Salir");
        b_salir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_salirActionPerformed(evt);
            }
        });
        getContentPane().add(b_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 560, 120, 40));

        l_modulo.setFont(new java.awt.Font("Trebuchet MS", 0, 28)); // NOI18N
        l_modulo.setForeground(new java.awt.Color(242, 242, 242));
        l_modulo.setText("Módulo de Productos");
        getContentPane().add(l_modulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 290, 30));

        l_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1800.png"))); // NOI18N
        l_fondo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(l_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 619));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t_id_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_id_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_id_productoActionPerformed

    private void t_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_categoriaActionPerformed

    private void b_administrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_administrarActionPerformed
        new VentanaAdminProductos().setVisible(true);
    }//GEN-LAST:event_b_administrarActionPerformed

    private void b_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_volverActionPerformed
        VentanaPrincipal menu = new VentanaPrincipal(); 
        menu.setVisible(true);                    
        this.dispose();
    }//GEN-LAST:event_b_volverActionPerformed

    private void b_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_salirActionPerformed
        VentanaLogin menu = new VentanaLogin(); 
        menu.setVisible(true);                    
        this.dispose();
    }//GEN-LAST:event_b_salirActionPerformed

    private void b_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_buscarActionPerformed
        if(!t_id_producto.getText().isEmpty()){
            Buscar_Id_producto();
        }else if(t_categoria.getText().isEmpty()){
            BuscarCategoria();
        }else{
            JOptionPane.showMessageDialog(null, "Debe ingresar ID o Categoría", "Alerta",
                                            JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_b_buscarActionPerformed


    public static void main(String args[]) {
 
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaProductos().setVisible(true);
            }
        });
    }
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_administrar;
    private javax.swing.JButton b_buscar;
    private javax.swing.JButton b_salir;
    private javax.swing.JButton b_volver;
    private javax.swing.JScrollPane jscrollpane;
    private javax.swing.JLabel l_fondo;
    private javax.swing.JLabel l_idCliente;
    private javax.swing.JLabel l_logo;
    private javax.swing.JLabel l_modulo;
    private javax.swing.JLabel l_nombreCliente;
    private javax.swing.JTextField t_categoria;
    private javax.swing.JTextField t_id_producto;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}
