package clases;

public class FacturaOficina extends DocumentoFactura {

    public FacturaOficina(String idFactura, String cliente, String total, String fecha) {
        super(idFactura, cliente, total, fecha);
    }

    @Override
    public String estructurarContenido() {
        
        return "-------------------------------------------------------------------------\n" +
               "                       FACTURA DE VENTA LEGAL                           \n" +
               "-------------------------------------------------------------------------\n" +
               "Código Registro: REG-" + getIdFactura() + "026\t\tEmisión: " + getFecha() + "\n" +
               "Adquiriente: " + getCliente().toUpperCase() + "\n" +
               "Régimen Comercial - Impuestos Incluidos\n" +
               "-------------------------------------------------------------------------\n" +
               "VALOR NETO OPERACIÓN:\t\t\t$" + getTotal() + "\n" +
               "-------------------------------------------------------------------------\n" +
               "Representación gráfica digitalizada de la transacción ferretera.\n";
    }
}
