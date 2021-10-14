package capitulo04.bloque04.Ejercicio02_Antiguedades;

import javax.swing.*;

public class Libro extends Antiguedad {
    private String titulo, autor;


    public Libro() {
        super();
    }

    public Libro(String nombre, String precio, int anyoFabricacion,
                 int precioVenta, String titulo, String autor) {
        super(nombre, precio, anyoFabricacion, precioVenta);
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void introduceLibro() {
        super.setNombre(JOptionPane.showInputDialog("Introduce el nombre del libro: "));
        super.setAnyoFabricacion(Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de fabricacion: ")));
        super.setPrecioVenta(Integer.parseInt(JOptionPane.showInputDialog("Introduce el precio de venta: ")));
        this.setAutor(JOptionPane.showInputDialog("Introduce el autor del libro: "));
        this.setTitulo(JOptionPane.showInputDialog("Introduce el titulo del libro: "));
    }

    public String toString() {
        return ("Antiguedad: " + super.getNombre() + "\n" +
                "Precio de venta: " + super.getPrecioVenta() + "\n" +
                "Origen: " + super.getAnyoFabricacion() + "\n" +
                "Titulo libro: " + this.titulo + "\n" +
                "Autor libro: " + this.autor + "\n\n");
    }
}
