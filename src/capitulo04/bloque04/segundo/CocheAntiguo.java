package capitulo04.bloque04.segundo;

import javax.swing.*;

public class CocheAntiguo extends Antiguedad{
    private String marca;
    private String modelo;

    public CocheAntiguo() {
        super();
    }
    public CocheAntiguo(String nombre, String precio, int anyoFabricacion, int precioVenta,
                        String marca, String modelo) {
        super(nombre, precio, anyoFabricacion, precioVenta);
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void introduceCoche(){
        super.setNombre(JOptionPane.showInputDialog("Introduce el nombre del coche: "));
        super.setAnyoFabricacion(Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de fabricacion: ")));
        super.setPrecioVenta(Integer.parseInt(JOptionPane.showInputDialog("Introduce el precio de venta: ")));
        this.setMarca(JOptionPane.showInputDialog("Introduce la marca del coche: "));
        this.setModelo(JOptionPane.showInputDialog("Introduce el modelo del coche: "));
    }

    public String toString(){
        return ("Coche: " + super.getNombre() + "\n" +
                "Precio de venta: " + super.getPrecioVenta() + "\n" +
                "Origen: " + super.getAnyoFabricacion() + "\n" +
                "Marca: " + this.marca +"\n" +
                "Modelo: " + this.modelo +"\n\n");
    }

}
