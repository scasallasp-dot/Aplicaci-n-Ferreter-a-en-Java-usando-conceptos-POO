package clases;

public class DescuentoMayorista extends Descuento {
    public DescuentoMayorista(double totalOriginal) {
        super(totalOriginal);
    }

    @Override
    public double calcularTotalConDescuento() {
        return totalOriginal * 0.90; // Aplica un 10% de descuento
    }

    @Override
    public double getPorcentaje() { return 10.0; }

    @Override
    public String getTipo() { return "Promoción Mayorista"; }
}