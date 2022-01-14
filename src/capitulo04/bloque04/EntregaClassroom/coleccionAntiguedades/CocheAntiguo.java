package capitulo04.bloque04.EntregaClassroom.coleccionAntiguedades;

import javax.swing.*;

public class CocheAntiguo extends Antiguedad {
    private String marca;
    private String modelo;

    /**
     * Constructor default
     */
    public CocheAntiguo() {
        super();
    }

    /**
     * Constructor general
     * @param nombre nombre coche
     * @param precio precio coche
     * @param anyoFabricacion año coche
     * @param precioVenta precioventa coche
     * @param marca marca coche
     * @param modelo modelo coche
     */
    public CocheAntiguo(String nombre, String precio, int anyoFabricacion, int precioVenta,
                        String marca, String modelo) {
        super(nombre, precio, anyoFabricacion, precioVenta);
        this.marca = marca;
        this.modelo = modelo;
    }

    /**
     *
     * @return marca coche
     */
    public String getMarca() {
        return marca;
    }

    /**
     *
     * @param marca introducir marca coche
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     *
     * @return modelo coche
     */
    public String getModelo() {
        return modelo;
    }

    /**
     *
     * @param modelo introducir modelo coche
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Metodo para introducir un coche
     */
    public void introduceCoche() {
        super.setNombre(JOptionPane.showInputDialog("Introduce el nombre del coche: "));
        super.setAnyoFabricacion(Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de fabricacion: ")));
        super.setPrecioVenta(Integer.parseInt(JOptionPane.showInputDialog("Introduce el precio de venta: ")));
        this.setMarca(JOptionPane.showInputDialog("Introduce la marca del coche: "));
        this.setModelo(JOptionPane.showInputDialog("Introduce el modelo del coche: "));
    }

    /**
     *
     * @return toString coche
     */
    public String toString() {
        return ("Coche: " + super.getNombre() + "\n" +
                "Precio de venta: " + super.getPrecioVenta() + "\n" +
                "Origen: " + super.getAnyoFabricacion() + "\n" +
                "Marca: " + this.marca + "\n" +
                "Modelo: " + this.modelo + "\n\n");
    }

}
