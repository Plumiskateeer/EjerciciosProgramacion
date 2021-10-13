package capitulo04.bloque04.segundo;

import javax.swing.*;

public class Jarron extends Antiguedad {
    private String paisProcedente;

    public Jarron() {
        super();
    }

    public Jarron(String nombre, String precio, int anyoFabricacion, int precioVenta, String paisProcedente) {
        super(nombre, precio, anyoFabricacion, precioVenta);
        this.paisProcedente = paisProcedente;
    }

    public String getPaisProcedente() {
        return paisProcedente;
    }

    public void setPaisProcedente(String paisProcedente) {
        this.paisProcedente = paisProcedente;
    }

    public void introduceJarron() {
        super.setNombre(JOptionPane.showInputDialog("Introduce el nombre de la joya: "));
        super.setAnyoFabricacion(Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de fabricacion: ")));
        super.setPrecioVenta(Integer.parseInt(JOptionPane.showInputDialog("Introduce el precio de venta: ")));
        this.setPaisProcedente((JOptionPane.showInputDialog("Introduce el pais de procedencia: ")));
    }

    public String toString() {
        return ("Jarron: " + super.getNombre() + "\n" +
                "Precio de venta: " + super.getPrecioVenta() + "\n" +
                "Origen: " + super.getAnyoFabricacion() + "\n" +
                "Pais de procedencia: " + this.paisProcedente + "\n\n");
    }
}
