package Ventanas;

import clases.Pedido;
import clases.PedidoLocal;
import clases.PedidoDomicilio;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VentanaPedido extends javax.swing.JDialog {

    private DefaultListModel<String> modeloLista;
    private double subtotalAcumulado = 0.0;
    private Pedido pedidoGenerado = null; 

    public VentanaPedido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponentsCustom();
        cargarProductosDesdeAlmacen(); 
    }

    private void initComponentsCustom() {
        setTitle("Nueva Orden de Pedido");
        setSize(450, 480);
        setLayout(new java.awt.FlowLayout());
        setLocationRelativeTo(null);

        lblCliente = new javax.swing.JLabel("Cliente:");
        txtCliente = new javax.swing.JTextField(15);
        
        lblProductos = new javax.swing.JLabel("Productos:"); 
        cmbProductos = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton("Agregar");

        modeloLista = new DefaultListModel<>();
        listaCarrito = new javax.swing.JList<>(modeloLista);
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(listaCarrito);
        scroll.setPreferredSize(new java.awt.Dimension(350, 150));

        cmbTipoPedido = new javax.swing.JComboBox<>(new String[]{"Retiro en Tienda", "Envío a Domicilio (+$3500)"});
        btnProcesar = new javax.swing.JButton("Confirmar Orden");

        add(lblCliente); 
        add(txtCliente);
        add(lblProductos); 
        add(cmbProductos); 
        add(btnAgregar); 
        add(scroll);
        add(cmbTipoPedido); 
        add(btnProcesar);

        // Extracción segura del precio evitando errores de formato numérico
        btnAgregar.addActionListener(e -> {
            if (cmbProductos.getSelectedItem() == null) return;
            
            String item = (String) cmbProductos.getSelectedItem();
            modeloLista.addElement(item);
            
            try {
                String[] partes = item.split(" - \\$");
                if (partes.length > 1) {
                    subtotalAcumulado += Double.parseDouble(partes[1].trim());
                }
            } catch (NumberFormatException ex) {
                System.out.println("Error al procesar subtotal: " + ex.getMessage());
            }
        });

        btnProcesar.addActionListener(e -> {
            if (modeloLista.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Añada artículos al carrito.", "Alerta", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int idCliente = 1; 
            String clienteNombre = txtCliente.getText().trim().isEmpty() ? "Cliente Mostrador" : txtCliente.getText().trim(); 
            String fechaHoy = LocalDate.now().toString();

            if (cmbTipoPedido.getSelectedIndex() == 0) {
                pedidoGenerado = new PedidoLocal(idCliente, clienteNombre, fechaHoy);
            } else {
                pedidoGenerado = new PedidoDomicilio(idCliente, clienteNombre, fechaHoy, 3500.0);
            }

            for (int i = 0; i < modeloLista.size(); i++) {
                String item = modeloLista.get(i); 
                String[] partes = item.split(" - ");
                
                int idProd = Integer.parseInt(partes[0].trim());
                String nombreProd = partes[1].trim();
                double precioProd = Double.parseDouble(partes[2].replace("$", "").trim());
                int cantidad = 1; 

                // CORREGIDO: Se cambió 'quantity' por la variable real 'cantidad'
                pedidoGenerado.agregarProducto(idProd, nombreProd, precioProd, cantidad);
            }

            dispose();
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

public Pedido getPedido() {
        return pedidoGenerado;
    }

    private void cargarProductosDesdeAlmacen() {
        String sql = "SELECT id_producto, nombre, precio FROM productos"; 
        conexiones.Conexiones conexion = new conexiones.Conexiones();
        
        
        try (Connection con = conexion.conectar();
             Statement consulta = con.createStatement();
             ResultSet resultado = consulta.executeQuery(sql)) {
            
            cmbProductos.removeAllItems();
            
            while (resultado.next()) {
                int id = resultado.getInt("id_producto");
                String nombreProd = resultado.getString("nombre");
                double precioProd = resultado.getDouble("precio");
                
                cmbProductos.addItem(id + " - " + nombreProd + " - $" + precioProd);
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL de Almacén: " + e);
        }
    }

    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblProductos; 
    private javax.swing.JTextField txtCliente;
    private javax.swing.JComboBox<String> cmbProductos, cmbTipoPedido;
    private javax.swing.JList<String> listaCarrito;
    private javax.swing.JButton btnAgregar, btnProcesar;
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

