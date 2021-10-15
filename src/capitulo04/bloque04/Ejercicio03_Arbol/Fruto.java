package capitulo04.bloque04.Ejercicio03_Arbol;

public class Fruto {
    private String nombre;

    /**
     * Constructor general
     * @param nombre nombre fruto
     */
    public Fruto(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return nombre fruto
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     *
     * @param nombre introducir nombre fruto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return toString fruto
     */
    public String toString() {
        return ("Fruto: " + this.nombre + "\n");
    }
}
