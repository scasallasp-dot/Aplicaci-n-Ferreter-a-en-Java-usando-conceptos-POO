package clases;

public class FacturaTicket extends DocumentoFactura {

    public FacturaTicket(String idFactura, String cliente, String total, String fecha) {
        super(idFactura, cliente, total, fecha); // Herencia
    }

    @Override
    public String estructurarContenido() {
        return "=============================\n" +
               "     FERRETERÍA LA SOLUCIÓN   \n" +
               "=============================\n" +
               "TICKET DE VENTA N°: " + getIdFactura() + "\n" +
               "Fecha: " + getFecha() + "\n" +
               "Cliente: " + getCliente() + "\n" +
               "-----------------------------\n" +
               "TOTAL PAGADO: $" + getTotal() + "\n" +
               "=============================\n" +
               "   ¡Gracias por su compra!   \n" +
               "=============================";
    }
}