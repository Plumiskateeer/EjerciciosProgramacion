package capitulo04.bloque04.tercero;

public class Fruto {
    private String nombre;

    public Fruto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return ("Fruto: " + this.nombre + "\n");
    }
}
