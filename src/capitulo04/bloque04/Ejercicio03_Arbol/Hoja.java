package capitulo04.bloque04.Ejercicio03_Arbol;

public class Hoja {
    private String nombre;

    /**
     * Constructor general hoja
     * @param nombre nombre hoja
     */
    public Hoja(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return nombre hoja
     */
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return ("Hoja: " + this.nombre + "\n");
    }
}
