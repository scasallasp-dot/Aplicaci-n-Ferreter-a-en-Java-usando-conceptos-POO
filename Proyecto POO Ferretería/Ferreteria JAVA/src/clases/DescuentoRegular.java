package clases;

public class DescuentoRegular extends Descuento {
    public DescuentoRegular(double totalOriginal) {
        super(totalOriginal);
    }

    @Override
    public double calcularTotalConDescuento() {
        return totalOriginal; // Sin descuento
    }

    @Override
    public double getPorcentaje() { return 0.0; }

    @Override
    public String getTipo() { return "Cliente Regular"; }
}