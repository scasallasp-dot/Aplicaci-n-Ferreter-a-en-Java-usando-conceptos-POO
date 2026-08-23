package clases;

public abstract class Actualizador {
    protected DatosFactura datos;

    public Actualizador(DatosFactura datos) {
        this.datos = datos;
    }

    
    public abstract boolean solicitarNuevosDatos();
}