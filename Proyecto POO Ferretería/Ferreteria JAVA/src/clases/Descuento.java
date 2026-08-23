package clases;

public abstract class Descuento {
    protected double totalOriginal;

    public Descuento(double totalOriginal) {
        this.totalOriginal = totalOriginal;
    }

   
    public abstract double calcularTotalConDescuento();
    public abstract double getPorcentaje();
    public abstract String getTipo();
}