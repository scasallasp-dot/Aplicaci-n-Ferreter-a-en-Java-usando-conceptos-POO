package clases;

public class PedidoDomicilio extends Pedido {
    private double cargoEnvio;

    
    public PedidoDomicilio(int idCliente, String cliente, String fecha, double cargoEnvio) {
        super(idCliente, cliente, fecha); 
        this.cargoEnvio = cargoEnvio;
    }

    @Override
    public double calcularTotalFinal() { 
        return getSubtotal() + cargoEnvio; 
    }

    @Override
    public String obtenerTipoPedido() { 
        return "Envío a Domicilio"; 
    }

    @Override
    public void generarDocumento() {
        System.out.println("=========================================");
        System.out.println("       FACTURA DE ENTREGA (DOMICILIO)    ");
        System.out.println("=========================================");
        System.out.println("ID Cliente: " + getIdCliente()); 
        System.out.println("Cliente: " + getCliente());
        System.out.println("Fecha: " + getFecha());
        System.out.println("Artículos: " + String.join(", ", getProductos()));
        System.out.println("-----------------------------------------");
        System.out.println("Subtotal: $" + getSubtotal());
        System.out.println("Cargo de Envío: $" + cargoEnvio);
        System.out.println("TOTAL COMPLETO: $" + calcularTotalFinal());
        System.out.println("=========================================");
    }
}