package capitulo04.bloque03.Ejercicio06_Restaurante;

public class Menu {
    private Plato primero, segundo, tercero;

    /**
     * Constructor default menu
     */
    public Menu() {
        primero = new Plato(1);
        segundo = new Plato(2);
        tercero = new Plato(3);
    }

    /**
     *
     * @return primer plato
     */
    public Plato getPrimero() {
        return primero;
    }

    /**
     *
     * @param primero introducir primer plato
     */
    public void setPrimero(Plato primero) {
        this.primero = primero;
    }

    /**
     *
     * @return segundo plato
     */
    public Plato getSegundo() {
        return segundo;
    }

    /**
     *
     * @param segundo introducir segundo plato
     */
    public void setSegundo(Plato segundo) {
        this.segundo = segundo;
    }

    /**
     *
     * @return tercer plato
     */
    public Plato getTercero() {
        return tercero;
    }

    /**
     *
     * @param tercero introducir tercer plato
     */
    public void setTercero(Plato tercero) {
        this.tercero = tercero;
    }

    /**
     *
     * @return imprime el menu, llamando a cada toString de los platos y imprime el precio del menu
     */
    public String toString() {
        return ("El menu es: " + "\n" +
                primero.toString() + "\n" +
                segundo.toString() + "\n" +
                tercero.toString() + "\n" +
                "El precio del menu es: " +
                (primero.getPrecio() + segundo.getPrecio() + tercero.getPrecio()) + "\n\n");
    }

}
