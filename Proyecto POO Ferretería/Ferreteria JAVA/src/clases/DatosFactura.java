package clases;

public class DatosFactura {
    // encapsulamiento
    private String idFactura;
    private String cliente;
    private String total;
    private String fecha;

    public DatosFactura(String idFactura, String cliente, String total, String fecha) {
        this.idFactura = idFactura;
        this.cliente = cliente;
        this.total = total;
        this.fecha = fecha;
    }

    // Métodos Getters y Setters
    public String getIdFactura() { return idFactura; }
    public void setIdFactura(String idFactura) { this.idFactura = idFactura; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getTotal() { return total; }
    public void setTotal(String total) { this.total = total; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}