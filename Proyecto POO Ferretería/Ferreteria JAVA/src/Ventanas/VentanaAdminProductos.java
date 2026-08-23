
package Ventanas;


import java.sql.Connection;
import conexiones.Conexiones;
import java.sql.Date;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class VentanaAdminProductos extends javax.swing.JFrame {

    public VentanaAdminProductos() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l_titulo_ventana = new javax.swing.JLabel();
        l_nombre = new javax.swing.JLabel();
        l_descripcion = new javax.swing.JLabel();
        l_precio = new javax.swing.JLabel();
        t_nombre = new javax.swing.JTextField();
        t_descripcion = new javax.swing.JTextField();
        t_precio = new javax.swing.JTextField();
        b_insertar = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();
        l_id_producto = new javax.swing.JLabel();
        t_idProducto = new javax.swing.JTextField();
        b_buscar = new javax.swing.JButton();
        l_existencia = new javax.swing.JLabel();
        l_categoria = new javax.swing.JLabel();
        l_fecha_ingreso = new javax.swing.JLabel();
        t_existencia = new javax.swing.JTextField();
        t_categoria = new javax.swing.JTextField();
        t_fecha_ingreso = new javax.swing.JTextField();
        b_actualizar = new javax.swing.JButton();
        b_borrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        l_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrar Productos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l_titulo_ventana.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        l_titulo_ventana.setForeground(new java.awt.Color(242, 242, 242));
        l_titulo_ventana.setText("Administrar Productos");
        getContentPane().add(l_titulo_ventana, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        l_nombre.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        l_nombre.setForeground(new java.awt.Color(242, 242, 242));
        l_nombre.setText("Nombre:");
        getContentPane().add(l_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        l_descripcion.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        l_descripcion.setForeground(new java.awt.Color(242, 242, 242));
        l_descripcion.setText("Descripción:");
        getContentPane().add(l_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        l_precio.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        l_precio.setForeground(new java.awt.Color(242, 242, 242));
        l_precio.setText("Precio:");
        getContentPane().add(l_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        t_nombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        t_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(t_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 180, 30));

        t_descripcion.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        t_descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_descripcionActionPerformed(evt);
            }
        });
        getContentPane().add(t_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 260, -1));

        t_precio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        t_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_precioActionPerformed(evt);
            }
        });
        getContentPane().add(t_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 180, 30));

        b_insertar.setBackground(new java.awt.Color(153, 255, 255));
        b_insertar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        b_insertar.setText("Insertar");
        b_insertar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_insertarActionPerformed(evt);
            }
        });
        getContentPane().add(b_insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 130, 50));

        b_cancelar.setBackground(new java.awt.Color(153, 255, 255));
        b_cancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        b_cancelar.setText("Cancelar");
        b_cancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(b_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 430, 130, 50));

        l_id_producto.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        l_id_producto.setForeground(new java.awt.Color(242, 242, 242));
        l_id_producto.setText("Id Producto:");
        getContentPane().add(l_id_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        t_idProducto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        t_idProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_idProductoActionPerformed(evt);
            }
        });
        getContentPane().add(t_idProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 70, 30));

        b_buscar.setBackground(new java.awt.Color(153, 255, 255));
        b_buscar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        b_buscar.setText("Buscar");
        b_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(b_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, -1, -1));

        l_existencia.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        l_existencia.setForeground(new java.awt.Color(242, 242, 242));
        l_existencia.setText("Existencia:");
        getContentPane().add(l_existencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, -1, -1));

        l_categoria.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        l_categoria.setForeground(new java.awt.Color(242, 242, 242));
        l_categoria.setText("Categoría:");
        getContentPane().add(l_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, -1, -1));

        l_fecha_ingreso.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        l_fecha_ingreso.setForeground(new java.awt.Color(242, 242, 242));
        l_fecha_ingreso.setText("Fecha de Ingreso:");
        getContentPane().add(l_fecha_ingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, -1, -1));

        t_existencia.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        t_existencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_existenciaActionPerformed(evt);
            }
        });
        getContentPane().add(t_existencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 180, 30));

        t_categoria.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        t_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_categoriaActionPerformed(evt);
            }
        });
        getContentPane().add(t_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 180, 30));

        t_fecha_ingreso.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        t_fecha_ingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_fecha_ingresoActionPerformed(evt);
            }
        });
        getContentPane().add(t_fecha_ingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 180, 30));

        b_actualizar.setBackground(new java.awt.Color(153, 255, 255));
        b_actualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        b_actualizar.setText("Actualizar");
        b_actualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(b_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 130, 50));

        b_borrar.setBackground(new java.awt.Color(153, 255, 255));
        b_borrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        b_borrar.setText("Borrar");
        b_borrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_borrarActionPerformed(evt);
            }
        });
        getContentPane().add(b_borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 430, 130, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("formato fecha: yyyy-mm-dd");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, -1, -1));

        l_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Gemini_Generated_Image_jvod7ujvod7ujvod.png"))); // NOI18N
        getContentPane().add(l_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nombreActionPerformed

    private void t_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_precioActionPerformed

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelarActionPerformed
        VentanaProductos menu = new VentanaProductos(); 
        menu.setVisible(true);                    
        this.dispose();
    }//GEN-LAST:event_b_cancelarActionPerformed

    private void b_insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_insertarActionPerformed
    String nombre = t_nombre.getText().trim();
    String descripcion = t_descripcion.getText().trim();
    String precioStr = t_precio.getText().trim();
    String existenciaStr = t_existencia.getText().trim();
    String categoriaStr = t_categoria.getText().trim(); // Nombre de la categoría
    String fechaIngreStr = t_fecha_ingreso.getText().trim();
    
    if (!t_idProducto.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(null, "No es necesario colocar Id del producto.\nDeje este campo vacío.", "Alerta", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    if (nombre.isEmpty() || precioStr.isEmpty() || existenciaStr.isEmpty() || categoriaStr.isEmpty() || fechaIngreStr.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Todos los campos (excepto ID) son obligatorios para insertar.", "Alerta", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    double precio;
    int existencia;
    try {
        precio = Double.parseDouble(precioStr);
        existencia = Integer.parseInt(existenciaStr);
    } catch(NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Debe colocar precio y existencia con valores numéricos válidos.", "Alerta", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
 
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate fechaIngreso;
    try {
        fechaIngreso = LocalDate.parse(fechaIngreStr, formatter);
        if (fechaIngreso.isAfter(LocalDate.now())) {
            JOptionPane.showMessageDialog(null, "La fecha ingresada no debe ser superior a la fecha actual", "Alerta", JOptionPane.WARNING_MESSAGE);
            return;
        }
    } catch (DateTimeParseException e) {
        JOptionPane.showMessageDialog(null, "La fecha debe tener formato año-mes-dia (AAAA-MM-DD)", "Alerta", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    int idCategoria = -1;
    Conexiones conexion = new Conexiones();
    Connection con = conexion.conectar();
    
    try {
        String sqlCategoria = "SELECT id_categoria FROM categorias WHERE nombre_categoria = ?";
        PreparedStatement consultaCat = con.prepareStatement(sqlCategoria);
        consultaCat.setString(1, categoriaStr);
        ResultSet rsCat = consultaCat.executeQuery();
        
        if (rsCat.next()) {
            idCategoria = rsCat.getInt("id_categoria");
        } else {
            JOptionPane.showMessageDialog(null, "La categoría '" + categoriaStr + "' no existe en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Se detiene porque la categoría no es válida
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al verificar la categoría: " + e.getMessage());
        return;
    }
    
    String sql = "INSERT INTO productos (nombre, descripcion, precio, existencia, id_categoria, fecha_ingreso) VALUES (?, ?, ?, ?, ?, ?)";
    
    try {
        PreparedStatement consulta = con.prepareStatement(sql);
        
        consulta.setString(1, nombre);
        consulta.setString(2, descripcion);
        consulta.setDouble(3, precio);
        consulta.setInt(4, existencia);
        consulta.setInt(5, idCategoria); // El número ID real encontrado
        consulta.setDate(6, java.sql.Date.valueOf(fechaIngreso));
        
        int filasInsertadas = consulta.executeUpdate();
        if (filasInsertadas > 0) {
            JOptionPane.showMessageDialog(null, "PRODUCTO INSERTADO CORRECTAMENTE", "RESULTADO", JOptionPane.INFORMATION_MESSAGE);
            
            t_idProducto.setText("");
            t_nombre.setText("");
            t_descripcion.setText("");
            t_precio.setText("");
            t_existencia.setText("");
            t_categoria.setText("");
            t_fecha_ingreso.setText("");
            
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "ERROR INSERTANDO PRODUCTO: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }


        
    }//GEN-LAST:event_b_insertarActionPerformed

    private void t_idProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_idProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_idProductoActionPerformed

    private void b_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_buscarActionPerformed
        String idProducto = t_idProducto.getText().trim();
        
        try{
            int idProductoInt = Integer.parseInt(idProducto);
            Conexiones conexion = new Conexiones();
            
            String sql = "select p.id_producto, p.nombre, p.descripcion, p.precio, p.existencia, "+
                         "p.fecha_ingreso, c.nombre_categoria from productos p join categorias c on p.id_categoria = c.id_categoria "+
                            "where id_producto =?";
            
            try{
                Connection con = conexion.conectar();
                PreparedStatement consultar = con.prepareStatement(sql);
                
                consultar.setInt(1, idProductoInt);
                ResultSet resultado = consultar.executeQuery();
                
                if(resultado.next()){
                    t_idProducto.setText(String.valueOf(resultado.getInt("id_producto")));
                    t_nombre.setText(String.valueOf(resultado.getString("nombre")));
                    t_descripcion.setText(String.valueOf(resultado.getString("descripcion")));
                    t_precio.setText(String.valueOf(resultado.getDouble("precio")));
                    t_existencia.setText(String.valueOf(resultado.getInt("existencia")));
                    t_categoria.setText(String.valueOf(resultado.getString("nombre_categoria")));
                    t_fecha_ingreso.setText(String.valueOf(resultado.getDate("fecha_ingreso")));
                }else{
                    JOptionPane.showMessageDialog(null,"Producto no encontrado", "Resultado",
                                                    JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(SQLException e){
                System.out.println("Error" +e);
                JOptionPane.showMessageDialog(null, "Error buscando producto", "Error",
                                          JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Debe ingresar ID producto correcto", "alerta",
                                          JOptionPane.WARNING_MESSAGE);
        }
        
 
        
    }//GEN-LAST:event_b_buscarActionPerformed

    private void t_existenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_existenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_existenciaActionPerformed

    private void t_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_categoriaActionPerformed

    private void t_fecha_ingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_fecha_ingresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_fecha_ingresoActionPerformed

    private void t_descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_descripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_descripcionActionPerformed

    private void b_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_actualizarActionPerformed
    
    String id = t_idProducto.getText().trim();
    String nombre = t_nombre.getText().trim();
    String precio = t_precio.getText().trim();
    String existencia = t_existencia.getText().trim();

   
    if (id.isEmpty() || nombre.isEmpty() || precio.isEmpty() || existencia.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos básicos.");
        return;
    }

    
    String sql = "UPDATE productos SET nombre = ?, precio = ?, existencia = ? WHERE id_producto = ?";

    try {
        Conexiones conexion = new Conexiones();
        Connection con = conexion.conectar();
        PreparedStatement consulta = con.prepareStatement(sql);

        //  parámetros a la consulta
        consulta.setString(1, nombre);
        consulta.setDouble(2, Double.parseDouble(precio));
        consulta.setInt(3, Integer.parseInt(existencia));
        consulta.setInt(4, Integer.parseInt(id));

        // actualización en la BD
        int filasAfectadas = consulta.executeUpdate();

        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(null, "¡Producto actualizado con éxito!");
            
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún producto con el ID especificado.");
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Precio y Existencia deben ser campos numéricos.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en la Base de Datos: " + e.getMessage());
    }

    }//GEN-LAST:event_b_actualizarActionPerformed

    private void b_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_borrarActionPerformed
        // ====================BOTON ELIMINAR====================
    String idProducto = t_idProducto.getText().trim();
    
    
    if (idProducto.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Debe ingresar o buscar el ID del producto que desea eliminar", "Alerta",
                JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Confirmación de seguridad
    int confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este producto?", 
            "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
    if (confirmar == JOptionPane.YES_OPTION) {
        try {
            int idProductoInt = Integer.parseInt(idProducto);
            Conexiones conexion = new Conexiones();
            Connection con = conexion.conectar();
            
            String sql = "DELETE FROM productos WHERE id_producto = ?";
            PreparedStatement consulta = con.prepareStatement(sql);
            consulta.setInt(1, idProductoInt);
            
            int filasEliminadas = consulta.executeUpdate();
            if (filasEliminadas > 0) {
                JOptionPane.showMessageDialog(null, "PRODUCTO ELIMINADO CORRECTAMENTE", "RESULTADO", JOptionPane.INFORMATION_MESSAGE);
                
                // Limpiar todos los campos de texto
                t_idProducto.setText("");
                t_nombre.setText("");
                t_descripcion.setText("");
                t_precio.setText("");
                t_existencia.setText("");
                t_categoria.setText("");
                t_fecha_ingreso.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún producto con ese ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID del producto debe ser un número válido", "Alerta", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto de la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_b_borrarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAdminProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_actualizar;
    private javax.swing.JButton b_borrar;
    private javax.swing.JButton b_buscar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JButton b_insertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel l_categoria;
    private javax.swing.JLabel l_descripcion;
    private javax.swing.JLabel l_existencia;
    private javax.swing.JLabel l_fecha_ingreso;
    private javax.swing.JLabel l_fondo;
    private javax.swing.JLabel l_id_producto;
    private javax.swing.JLabel l_nombre;
    private javax.swing.JLabel l_precio;
    private javax.swing.JLabel l_titulo_ventana;
    private javax.swing.JTextField t_categoria;
    private javax.swing.JTextField t_descripcion;
    private javax.swing.JTextField t_existencia;
    private javax.swing.JTextField t_fecha_ingreso;
    private javax.swing.JTextField t_idProducto;
    private javax.swing.JTextField t_nombre;
    private javax.swing.JTextField t_precio;
    // End of variables declaration//GEN-END:variables
}
