package clases;

import javax.swing.JOptionPane;

public class ActualizadorFormulario extends Actualizador {

    public ActualizadorFormulario(DatosFactura datos) {
        super(datos);
    }

    @Override
    public boolean solicitarNuevosDatos() {
        //Modificar Nombre del Cliente
        String nuevoCliente = JOptionPane.showInputDialog(null, 
                "Modificar nombre del cliente o Razón Social:", datos.getCliente());
        
        if (nuevoCliente == null) return false; // 
        if (!nuevoCliente.trim().isEmpty()) {
            datos.setCliente(nuevoCliente.trim());
        }

        //  Modificar Fecha de Emisión
        String nuevaFecha = JOptionPane.showInputDialog(null, 
                "Modificar fecha de emisión (AAAA-MM-DD):", datos.getFecha());
        
        if (nuevaFecha == null) return false; 
        if (!nuevaFecha.trim().isEmpty()) {
            datos.setFecha(nuevaFecha.trim());
        }

        return true; 
    }
}   