package capitulo04.bloque04.primero;

public class Cliente {
    private String nombre;
    private int ID;

    public Cliente(String nombre, int id) {
        this.nombre = nombre;
        this.ID = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int dni) {
        this.ID = dni;
    }

    public String toString() {
        return ("Cliente: " + this.getID() + "\n" +
                "Producto que ha comprado: " + this.getID() + "\n" +
                "Nombre: " + this.getNombre() + "\n\n");
    }
}
