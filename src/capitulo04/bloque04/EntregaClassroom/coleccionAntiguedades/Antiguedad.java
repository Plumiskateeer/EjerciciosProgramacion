package capitulo04.bloque04.EntregaClassroom.coleccionAntiguedades;

import javax.swing.*;

public class Antiguedad {
    private String nombre;
    private int anyoFabricacion, precioVenta;

    /**
     * Constructor default
     */
    public Antiguedad() {
        this.nombre = null;
        this.anyoFabricacion = 0;
        this.precioVenta = 0;
    }

    /**
     * Constructor general
     * @param nombre nombre antiguedad
     * @param precio precio antiguedad
     * @param anyoFabricacion año fabricacion antiguedad
     * @param precioVenta precio venta antiguedad
     */
    public Antiguedad(String nombre, String precio, int anyoFabricacion, int precioVenta) {
        this.nombre = nombre;
        this.anyoFabricacion = anyoFabricacion;
        this.precioVenta = precioVenta;
    }

    /**
     *
     * @return nombre antiguedad
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre introducir nombre antiguedad
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return año fabricacion
     */
    public int getAnyoFabricacion() {
        return anyoFabricacion;
    }

    /**
     *
     * @param anyoFabricacion introducir año fabricacion
     */
    public void setAnyoFabricacion(int anyoFabricacion) {
        this.anyoFabricacion = anyoFabricacion;
    }

    /**
     *
     * @return precio venta
     */
    public int getPrecioVenta() {
        return precioVenta;
    }

    /**
     *
     * @param precioVenta introducir precio venta
     */
    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * Metodo introducir una antiguedad
     */
    public void introduceAntiguedad() {
        this.setNombre(JOptionPane.showInputDialog("Introduce el nombre de la antiguedad: "));
        this.setAnyoFabricacion(Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de fabricacion: ")));
        this.setPrecioVenta(Integer.parseInt(JOptionPane.showInputDialog("Introduce el precio de venta: ")));
    }

    /**
     *
     * @return toString antiguedad
     */
    public String toString() {
        return ("Antiguedad: " + this.nombre + "\n" +
                "Precio de venta: " + this.precioVenta + "\n" +
                "Origen: " + this.anyoFabricacion + "\n\n");
    }
}
