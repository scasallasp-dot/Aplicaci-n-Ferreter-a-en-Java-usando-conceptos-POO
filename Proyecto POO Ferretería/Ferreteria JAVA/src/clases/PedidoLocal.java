package clases;

public class PedidoLocal extends Pedido {
    
    public PedidoLocal(int idCliente, String cliente, String fecha) {
        super(idCliente, cliente, fecha);
    }

    @Override
    public double calcularTotalFinal() { 
        return getSubtotal(); 
    }

    @Override
    public String obtenerTipoPedido() { 
        return "Retiro en Local"; 
    }

    @Override
    public void generarDocumento() {
        System.out.println("=========================================");
        System.out.println("        TICKET DE VENTA (LOCAL)          ");
        System.out.println("=========================================");
        System.out.println("ID Cliente: " + getIdCliente());
        System.out.println("Cliente: " + getCliente());
        System.out.println("Fecha: " + getFecha());
        System.out.println("Artículos: " + String.join(", ", getProductos()));
        System.out.println("-----------------------------------------");
        System.out.println("TOTAL NETO: $" + calcularTotalFinal());
        System.out.println("=========================================");
    }
}