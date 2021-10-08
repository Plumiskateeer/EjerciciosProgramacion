package capitulo04.bloque04.segundo;

import javax.swing.*;

public class Joya extends Antiguedad{
    private String materialFab;

    public Joya() {
    super();
    }

    public Joya(String nombre, String precio, int anyoFabricacion, int precioVenta, String materialFab){
        super(nombre, precio, anyoFabricacion, precioVenta);
        this.materialFab = materialFab;
    }

    public String getMaterialFab() {
        return materialFab;
    }

    public void setMaterialFab(String materialFab) {
        this.materialFab = materialFab;
    }

    public void introduceJoya(){
        super.setNombre(JOptionPane.showInputDialog("Introduce el nombre de la joya: "));
        super.setAnyoFabricacion(Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de fabricacion: ")));
        super.setPrecioVenta(Integer.parseInt(JOptionPane.showInputDialog("Introduce el precio de venta: ")));
        this.setMaterialFab((JOptionPane.showInputDialog("Introduce el material de fabricacion: ")));
    }

    public String toString(){
        return ("Joya: " + super.getNombre() + "\n" +
                "Precio de venta: " + super.getPrecioVenta() + "\n" +
                "Origen: " + super.getAnyoFabricacion() + "\n" +
                "Material de fabricacion: " + this.materialFab +"\n\n");
    }
}
