package capitulo04.bloque04.segundo;

import javax.swing.*;

public class Antiguedad {
    private String nombre;
    private int anyoFabricacion, precioVenta;

    public Antiguedad(){}
    public Antiguedad(String nombre, String precio, int anyoFabricacion, int precioVenta) {
        this.nombre = nombre;
        this.anyoFabricacion = anyoFabricacion;
        this.precioVenta = precioVenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnyoFabricacion() {
        return anyoFabricacion;
    }

    public void setAnyoFabricacion(int anyoFabricacion) {
        this.anyoFabricacion = anyoFabricacion;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void introduceAntiguedad(){
        this.setNombre(JOptionPane.showInputDialog("Introduce el nombre de la antiguedad: "));
        this.setAnyoFabricacion(Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de fabricacion: ")));
        this.setPrecioVenta(Integer.parseInt(JOptionPane.showInputDialog("Introduce el precio de venta: ")));
    }

    public String toString(){
        return ("Antiguedad: " + this.nombre + "\n" +
                "Precio de venta: " + this.precioVenta + "\n" +
                "Origen: " + this.anyoFabricacion + "\n\n");
    }
}
