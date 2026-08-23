
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

import clases.Imprimible;
import clases.FacturaTicket;
import clases.FacturaOficina;

public class VentanaVentas extends javax.swing.JFrame {

    public VentanaVentas() {
    initComponents();
    setLocationRelativeTo(null);
    setResizable(false);
    mostrar();
}
    
public void mostrar() {
    String sql = "SELECT dv.id_detalle_venta, cli.nombre AS nombre_cliente, dv.cantidad, p.nombre, " +
                 "dv.precio_unitario, v.total_venta, v.fecha_venta " +
                 "FROM ventas v " +
                 "JOIN clientes cli ON v.id_cliente = cli.id_cliente " +
                 "JOIN detalle_venta dv ON v.id_venta = dv.id_venta " +
                 "JOIN productos p ON dv.id_producto = p.id_producto";

    Conexiones conexion = new Conexiones();
    Connection con = conexion.conectar(); 
    System.out.println(sql);

    
    DefaultTableModel modelo = new DefaultTableModel(
            new Object[][]{},
            new String[]{"FACTURA", "Nombre Cliente", "Cantidad", "Nombre Producto", "Precio Unitario", "Total Venta", "Fecha Venta"}
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    tabla1.setModel(modelo);

    String[] datos = new String[7];

    try {
        Statement consulta = con.createStatement();
        ResultSet resultado = consulta.executeQuery(sql);

        while (resultado.next()) {
            datos[0] = resultado.getString("id_detalle_venta");
            datos[1] = resultado.getString("nombre_cliente");
            datos[2] = resultado.getString("cantidad");
            datos[3] = resultado.getString("nombre");
            datos[4] = resultado.getString("precio_unitario");
            datos[5] = resultado.getString("total_venta");
            datos[6] = resultado.getString("fecha_venta");
            modelo.addRow(datos);
        }

        centrarTexto(tabla1); 

    } catch (SQLException e) {
        System.out.println("Error: " + e);
    }
} 


public void centrarTexto(JTable tabla) {
    DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
    centrado.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
    for (int i = 0; i < tabla.getColumnCount(); i++) {
        tabla.getColumnModel().getColumn(i).setCellRenderer(centrado);
    }
}

public void buscarPorFactura(String idFactura) {
    
    if (idFactura.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, ingrese un número de factura para buscar.", "Alerta", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String sql = "SELECT dv.id_detalle_venta, cli.nombre AS nombre_cliente, dv.cantidad, p.nombre, " +
                 "dv.precio_unitario, v.total_venta, v.fecha_venta " +
                 "FROM ventas v " +
                 "JOIN clientes cli ON v.id_cliente = cli.id_cliente " +
                 "JOIN detalle_venta dv ON v.id_venta = dv.id_venta " +
                 "JOIN productos p ON dv.id_producto = p.id_producto " +
                 "WHERE dv.id_detalle_venta = ?"; // Buscamos por el ID de la factura

    Conexiones conexion = new Conexiones();
    Connection con = conexion.conectar();

    DefaultTableModel modelo = new DefaultTableModel(
            new Object[][]{},
            new String[]{"FACTURA", "Nombre Cliente", "Cantidad", "Nombre Producto", "Precio Unitario", "Total Venta", "Fecha Venta"}
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    tabla1.setModel(modelo);
    String[] datos = new String[7];

    try {
        PreparedStatement consulta = con.prepareStatement(sql);
        // Convertimos el texto a número entero para el WHERE
        consulta.setInt(1, Integer.parseInt(idFactura.trim()));
        
        ResultSet resultado = consulta.executeQuery();

        boolean encontro = false;
        while (resultado.next()) {
            encontro = true;
            datos[0] = resultado.getString("id_detalle_venta");
            datos[1] = resultado.getString("nombre_cliente");
            datos[2] = resultado.getString("cantidad");
            datos[3] = resultado.getString("nombre");
            datos[4] = resultado.getString("precio_unitario");
            datos[5] = resultado.getString("total_venta");
            datos[6] = resultado.getString("fecha_venta");
            modelo.addRow(datos);
        }

        if (!encontro) {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna factura con el número: " + idFactura, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            mostrar(); 
        } else {
            centrarTexto(tabla1); 
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "El número de factura debe contener únicamente dígitos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        System.out.println("Error al buscar factura: " + e);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l_logo = new javax.swing.JLabel();
        t_numFactura = new javax.swing.JTextField();
        l_nombreCliente = new javax.swing.JLabel();
        b_buscar = new javax.swing.JButton();
        jscrollpane = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        b_volver = new javax.swing.JButton();
        b_salir = new javax.swing.JButton();
        l_modulo = new javax.swing.JLabel();
        b_factura = new javax.swing.JButton();
        b_nuevoPedido = new javax.swing.JButton();
        l_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modulo Ventas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ferreteria_200x200.png"))); // NOI18N
        getContentPane().add(l_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 10, 190, 180));

        t_numFactura.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        t_numFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_numFacturaActionPerformed(evt);
            }
        });
        getContentPane().add(t_numFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 130, 30));

        l_nombreCliente.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        l_nombreCliente.setForeground(new java.awt.Color(242, 242, 242));
        l_nombreCliente.setText("No factura");
        getContentPane().add(l_nombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, -1));

        b_buscar.setBackground(new java.awt.Color(204, 255, 255));
        b_buscar.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        b_buscar.setText("Buscar");
        b_buscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(b_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 120, 90));

        tabla1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "factura", "cliente", "cantidad", "articulo", "precio unidad", "total", "fecha"
            }
        ));
        jscrollpane.setViewportView(tabla1);

        getContentPane().add(jscrollpane, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 790, 280));

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
        getContentPane().add(b_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 560, 120, 40));

        l_modulo.setFont(new java.awt.Font("Trebuchet MS", 0, 28)); // NOI18N
        l_modulo.setForeground(new java.awt.Color(242, 242, 242));
        l_modulo.setText("Módulo de Ventas");
        getContentPane().add(l_modulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 290, 30));

        b_factura.setText("Factura");
        b_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_facturaActionPerformed(evt);
            }
        });
        getContentPane().add(b_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 150, 60));

        b_nuevoPedido.setText("Nuevo pedido");
        b_nuevoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_nuevoPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(b_nuevoPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 140, 60));

        l_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Gemini_Generated_Image_jvod7ujvod7ujvod.png"))); // NOI18N
        l_fondo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(l_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t_numFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_numFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_numFacturaActionPerformed

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
        buscarPorFactura(t_numFactura.getText());
    }//GEN-LAST:event_b_buscarActionPerformed

    private void b_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_facturaActionPerformed
        int filaSeleccionada = tabla1.getSelectedRow();
        
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una factura de la tabla.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        clases.DatosFactura datosFactura = new clases.DatosFactura(
            tabla1.getValueAt(filaSeleccionada, 0).toString(),
            tabla1.getValueAt(filaSeleccionada, 1).toString(),
            tabla1.getValueAt(filaSeleccionada, 5).toString(),
            tabla1.getValueAt(filaSeleccionada, 6).toString()
        );
        
        int respuestaEdicion = JOptionPane.showConfirmDialog(this, 
                "¿Desea modificar los datos del cliente o fecha antes de imprimir?", 
                "Actualizar Datos de Facturación", JOptionPane.YES_NO_OPTION);
        
        if (respuestaEdicion == JOptionPane.YES_OPTION) {
            clases.Actualizador actualizador = new clases.ActualizadorFormulario(datosFactura);
            
            if (!actualizador.solicitarNuevosDatos()) {
                JOptionPane.showMessageDialog(this, "Modificación cancelada por el usuario.", "Operación Cancelada", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        
        double total = Double.parseDouble(datosFactura.getTotal());
        clases.Descuento descuentoAplicado;
        if (total >= 50000) {
            descuentoAplicado = new clases.DescuentoMayorista(total);
        } else {
            descuentoAplicado = new clases.DescuentoRegular(total);
        }
        
        double totalFinal = descuentoAplicado.calcularTotalConDescuento();
        
        String[] opciones = {"Ticket Corto (POS)", "Factura Extendida (Oficina)"};
        int seleccion = JOptionPane.showOptionDialog(this, 
                "Resumen de Cuenta Actualizado:\n" +
                "• Cliente: " + datosFactura.getCliente() + "\n" +
                "• Fecha: " + datosFactura.getFecha() + "\n" +
                "• Tipo Descuento: " + descuentoAplicado.getTipo() + "\n" +
                "• Total Neto: $" + totalFinal + "\n\n" +
                "Seleccione el formato de impresión:", 
                "Procesando Factura #" + datosFactura.getIdFactura(), 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, opciones, opciones[0]);
                
        if (seleccion == -1) return; 
        
        Imprimible documento;
        if (seleccion == 0) {
            documento = new FacturaTicket(datosFactura.getIdFactura(), datosFactura.getCliente(), String.valueOf(totalFinal), datosFactura.getFecha()); 
        } else {
            documento = new FacturaOficina(datosFactura.getIdFactura(), datosFactura.getCliente(), String.valueOf(totalFinal), datosFactura.getFecha()); 
        }
        
        documento.generarDocumento();
        JOptionPane.showMessageDialog(this, "¡Documento enviado a impresión correctamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_b_facturaActionPerformed

    private void b_nuevoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_nuevoPedidoActionPerformed
        VentanaPedido pantallaPedido = new VentanaPedido(this, true);
        pantallaPedido.setVisible(true);
        
        clases.Pedido pedidoResultado = pantallaPedido.getPedido();
        if (pedidoResultado == null) return; 
        

        conexiones.Conexiones conexion = new conexiones.Conexiones();
        Connection con = conexion.conectar();
        
        String sqlVenta = "INSERT INTO ventas (id_cliente, total_venta, fecha_venta) VALUES (?, ?, ?)";
        String sqlDetalle = "INSERT INTO detalle_venta (id_venta, id_producto, cantidad, precio_unitario) VALUES (?, ?, ?, ?)";
        
        try {
            con.setAutoCommit(false);
            
            PreparedStatement psVenta = con.prepareStatement(sqlVenta, Statement.RETURN_GENERATED_KEYS);
            psVenta.setInt(1, pedidoResultado.getIdCliente());
            psVenta.setDouble(2, pedidoResultado.calcularTotalFinal());
            psVenta.setString(3, pedidoResultado.getFecha());
            psVenta.executeUpdate();
            
            // Obtener el ID asignado a la venta actual
            ResultSet rsKeys = psVenta.getGeneratedKeys();
            int idVentaGenerado = 0;
            if (rsKeys.next()) {
                idVentaGenerado = rsKeys.getInt(1);
            }
            
            PreparedStatement psDetalle = con.prepareStatement(sqlDetalle);
            for (int i = 0; i < pedidoResultado.getProductos().size(); i++) {
                psDetalle.setInt(1, idVentaGenerado);
                psDetalle.setInt(2, pedidoResultado.getIdProductos().get(i));
                psDetalle.setInt(3, pedidoResultado.getCantidades().get(i));
                psDetalle.setDouble(4, pedidoResultado.getPrecios().get(i));
                psDetalle.addBatch(); // Procesamiento por lotes
            }
            psDetalle.executeBatch();
            
            con.commit();
            JOptionPane.showMessageDialog(this, "¡Pedido registrado con éxito en la Base de Datos!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            // 2. Ofrecer la impresión del comprobante al usuario
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea imprimir el comprobante del pedido ahora?", "Impresión", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                clases.Imprimible documentoFactura = pedidoResultado; 
                documentoFactura.generarDocumento(); 
            }
            
        } catch (SQLException e) {
            try {
                if (con != null) con.rollback(); // Deshace los cambios si hubo fallos
            } catch (SQLException ex) { System.out.println("Error Rollback: " + ex); }
            System.out.println("Error Transaccional: " + e);
            JOptionPane.showMessageDialog(this, "Error al almacenar la venta.", "Error SQL", JOptionPane.ERROR_MESSAGE);
        } finally {
            mostrar(); 
        }
    
    }//GEN-LAST:event_b_nuevoPedidoActionPerformed


    public static void main(String args[]) {
 
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaVentas().setVisible(true);
            }
        });
    }
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_buscar;
    private javax.swing.JButton b_factura;
    private javax.swing.JButton b_nuevoPedido;
    private javax.swing.JButton b_salir;
    private javax.swing.JButton b_volver;
    private javax.swing.JScrollPane jscrollpane;
    private javax.swing.JLabel l_fondo;
    private javax.swing.JLabel l_logo;
    private javax.swing.JLabel l_modulo;
    private javax.swing.JLabel l_nombreCliente;
    private javax.swing.JTextField t_numFactura;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}
