package clases;

public abstract class DocumentoFactura implements Imprimible {
    // Encapsulamiento
    private String idFactura;
    private String cliente;
    private String total;
    private String fecha;

    public DocumentoFactura(String idFactura, String cliente, String total, String fecha) {
        this.idFactura = idFactura;
        this.cliente = cliente;
        this.total = total;
        this.fecha = fecha;
    }

    public String getIdFactura() { return idFactura; }
    public String getCliente() { return cliente; }
    public String getTotal() { return total; }
    public String getFecha() { return fecha; }

  
    public abstract String estructurarContenido();

    @Override
    public void generarDocumento() {
        String cuerpo = estructurarContenido();
        //simulamos el envío a la impresora
        javax.swing.JOptionPane.showMessageDialog(null, cuerpo, "Imprimiendo Factura N° " + idFactura, javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
}