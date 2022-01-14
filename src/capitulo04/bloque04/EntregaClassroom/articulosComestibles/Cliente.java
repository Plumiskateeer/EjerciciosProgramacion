package capitulo04.bloque04.EntregaClassroom.articulosComestibles;

public class Cliente {
    private String nombre;
    private int ID;

    /**
     * Constructor general cliente
     * @param nombre nombre cliente
     * @param id id cliente
     */
    public Cliente(String nombre, int id) {
        this.nombre = nombre;
        this.ID = id;
    }

    /**
     *
     * @return nombre cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre introducir nombre cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return id cliente
     */
    public int getID() {
        return ID;
    }

    /**
     *
     * @param dni introducir dni cliente
     */
    public void setID(int dni) {
        this.ID = dni;
    }

    /**
     *
     * @return toString cliente
     */
    public String toString() {
        return ("Cliente: " + this.getID() + "\n" +
                "Producto que ha comprado: " + this.getID() + "\n" +
                "Nombre: " + this.getNombre() + "\n\n");
    }
}
