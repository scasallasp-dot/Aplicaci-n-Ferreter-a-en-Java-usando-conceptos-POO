package clases;

import java.util.ArrayList;
import java.util.List;

public abstract class Pedido implements Imprimible {
    private int idCliente; // <-- Nuevo atributo encapsulado para la BD
    private String cliente;
    protected List<String> productos;
    protected List<Integer> idProductos; 
    protected List<Double> precios;      
    protected List<Integer> cantidades;  
    protected double subtotal;
    protected String fecha;

    public Pedido(int idCliente, String cliente, String fecha) {
        this.idCliente = idCliente;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.idProductos = new ArrayList<>();
        this.precios = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.subtotal = 0.0;
        this.fecha = fecha;
    }

    public void agregarProducto(int idProducto, String producto, double precio, int cantidad) {
        this.idProductos.add(idProducto);
        this.productos.add(producto);
        this.precios.add(precio);
        this.cantidades.add(cantidad);
        this.subtotal += (precio * cantidad);
    }

    public abstract double calcularTotalFinal();
    public abstract String obtenerTipoPedido();

    // Getters y Setters
    public int getIdCliente() { return idCliente; }
    public String getCliente() { return cliente; }
    public double getSubtotal() { return subtotal; }
    public List<String> getProductos() { return productos; }
    public List<Integer> getIdProductos() { return idProductos; }
    public List<Double> getPrecios() { return precios; }
    public List<Integer> getCantidades() { return cantidades; }
    public String getFecha() { return fecha; }
}