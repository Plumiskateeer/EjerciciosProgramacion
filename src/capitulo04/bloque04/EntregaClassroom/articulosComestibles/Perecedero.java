package capitulo04.bloque04.EntregaClassroom.articulosComestibles;

public class Perecedero extends Producto {
    String fecha;

    /**
     * Constructor general perecedero
     * @param codigo codigo perecedero
     * @param precio precio perecedero
     * @param nombre precio perecedero
     * @param id id perecedero
     */
    public Perecedero(int codigo, int precio, String nombre, int id, String fecha) {
        super(codigo, precio, nombre, id);
        this.fecha = fecha;
    }

    /**
     *
     * @return toString perecedero
     */
    public String toString() {
        return ("Producto: " + super.getId() + "\n" +
                "Codigo: " + super.getNombre() + "\n" +
                "Nombre: " + super.getNombre() + "\n" +
                "Precio: " + super.getPrecio() + "\n" +
                "Fecha perecedero: (" + this.fecha + ")" + "\n\n");
    }

}
