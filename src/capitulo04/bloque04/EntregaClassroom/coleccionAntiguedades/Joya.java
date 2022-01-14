package capitulo04.bloque04.EntregaClassroom.coleccionAntiguedades;

import javax.swing.*;

public class Joya extends Antiguedad {
    private String materialFab;

    /**
     * Constructor default joya
     */
    public Joya() {
        super();
    }

    /**
     * Constructor general
     * @param nombre nombre joya
     * @param precio precio joya
     * @param anyoFabricacion año fabricacion joya
     * @param precioVenta precio venta joya
     * @param materialFab material fabricacion joya
     */
    public Joya(String nombre, String precio, int anyoFabricacion, int precioVenta, String materialFab) {
        super(nombre, precio, anyoFabricacion, precioVenta);
        this.materialFab = materialFab;
    }

    /**
     *
     * @return material fabricacion
     */
    public String getMaterialFab() {
        return materialFab;
    }

    /**
     *
     * @param materialFab introducir material fabricacion
     */
    public void setMaterialFab(String materialFab) {
        this.materialFab = materialFab;
    }

    /**
     * Metodo para introducir una joya
     */
    public void introduceJoya() {
        super.setNombre(JOptionPane.showInputDialog("Introduce el nombre de la joya: "));
        super.setAnyoFabricacion(Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de fabricacion: ")));
        super.setPrecioVenta(Integer.parseInt(JOptionPane.showInputDialog("Introduce el precio de venta: ")));
        this.setMaterialFab((JOptionPane.showInputDialog("Introduce el material de fabricacion: ")));
    }

    /**
     *
     * @return toString joya
     */
    public String toString() {
        return ("Joya: " + super.getNombre() + "\n" +
                "Precio de venta: " + super.getPrecioVenta() + "\n" +
                "Origen: " + super.getAnyoFabricacion() + "\n" +
                "Material de fabricacion: " + this.materialFab + "\n\n");
    }
}
