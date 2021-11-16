package capitulo04.bloque03.Ejercicio07_Rectangulo;

public class Rectangulo {
    private int altura, base;

    /**
     * Constructor general rectangulo
     * @param altura altura rectangulo
     * @param base base rectangulo
     */
    public Rectangulo(int altura, int base) {
        this.altura = altura;
        this.base = base;
    }

    /**
     *
     * @return altura rectangulo
     */
    public int getAltura() {
        return this.altura;
    }

    /**
     *
     * @param altura introducir altura rectangulo
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     *
     * @return base rectangulo
     */
    public int getBase() {
        return this.base;
    }

    /**
     *
     * @param base introducir base rectangulo
     */
    public void setBase(int base) {
        this.base = base;
    }

    /**
     *
     * @return imprimir el rectangulo con asteriscos
     */
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < base; i++) {
            str.append("\n");
            //str.append(" * ".repeat(Math.max(0, altura)));
        }
        return str.toString();
    }

}
