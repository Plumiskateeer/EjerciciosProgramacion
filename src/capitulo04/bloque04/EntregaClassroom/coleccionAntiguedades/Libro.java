package capitulo04.bloque04.EntregaClassroom.coleccionAntiguedades;

import javax.swing.*;

public class Libro extends Antiguedad {
    private String titulo, autor;

    /**
     * Constructor default
     */
    public Libro() {
        super();
    }

    /***
     * Constructor general
     * @param nombre nombre libro
     * @param precio precio libro
     * @param anyoFabricacion año fabricacion libro
     * @param precioVenta precio venta libro
     * @param titulo titulo libro
     * @param autor autor libro
     */
    public Libro(String nombre, String precio, int anyoFabricacion,
                 int precioVenta, String titulo, String autor) {
        super(nombre, precio, anyoFabricacion, precioVenta);
        this.titulo = titulo;
        this.autor = autor;
    }

    /**
     *
     * @return titulo libro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     * @param titulo introducir titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     *
     * @return autor libro
     */
    public String getAutor() {
        return autor;
    }

    /**
     *
     * @param autor introducir autor libro
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Metodo para introducir un libro
     */
    public void introduceLibro() {
        super.setNombre(JOptionPane.showInputDialog("Introduce el nombre del libro: "));
        super.setAnyoFabricacion(Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de fabricacion: ")));
        super.setPrecioVenta(Integer.parseInt(JOptionPane.showInputDialog("Introduce el precio de venta: ")));
        this.setAutor(JOptionPane.showInputDialog("Introduce el autor del libro: "));
        this.setTitulo(JOptionPane.showInputDialog("Introduce el titulo del libro: "));
    }

    /**
     *
     * @return toString libro
     */
    public String toString() {
        return ("Antiguedad: " + super.getNombre() + "\n" +
                "Precio de venta: " + super.getPrecioVenta() + "\n" +
                "Origen: " + super.getAnyoFabricacion() + "\n" +
                "Titulo libro: " + this.titulo + "\n" +
                "Autor libro: " + this.autor + "\n\n");
    }
}
