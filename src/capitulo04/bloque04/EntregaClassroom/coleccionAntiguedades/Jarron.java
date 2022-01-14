package capitulo04.bloque04.EntregaClassroom.coleccionAntiguedades;

import javax.swing.*;

public class Jarron extends Antiguedad {
    private String paisProcedente;

    /**
     * Constructor default
     */
    public Jarron() {
        super();
    }

    /**
     * Constructor general
     * @param nombre nombre jarron
     * @param precio precio jarron
     * @param anyoFabricacion año jarron
     * @param precioVenta precio venta jarron
     * @param paisProcedente pais jarron
     */
    public Jarron(String nombre, String precio, int anyoFabricacion, int precioVenta, String paisProcedente) {
        super(nombre, precio, anyoFabricacion, precioVenta);
        this.paisProcedente = paisProcedente;
    }

    /**
     *
     * @return pais procedente jarron
     */
    public String getPaisProcedente() {
        return paisProcedente;
    }

    /**
     *
     * @param paisProcedente introducir pais procedente jarron
     */
    public void setPaisProcedente(String paisProcedente) {
        this.paisProcedente = paisProcedente;
    }

    /**
     * Metodo para introducir un jarron
     */
    public void introduceJarron() {
        super.setNombre(JOptionPane.showInputDialog("Introduce el nombre de la joya: "));
        super.setAnyoFabricacion(Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de fabricacion: ")));
        super.setPrecioVenta(Integer.parseInt(JOptionPane.showInputDialog("Introduce el precio de venta: ")));
        this.setPaisProcedente((JOptionPane.showInputDialog("Introduce el pais de procedencia: ")));
    }

    /**
     *
     * @return toString jarron
     */
    public String toString() {
        return ("Jarron: " + super.getNombre() + "\n" +
                "Precio de venta: " + super.getPrecioVenta() + "\n" +
                "Origen: " + super.getAnyoFabricacion() + "\n" +
                "Pais de procedencia: " + this.paisProcedente + "\n\n");
    }
}
