package capitulo04.bloque04.Ejercicio03_Arbol;

public class Arbol {
    private Arbol izq, der;
    private Hoja hoja;
    private Fruto fruto;

    /**
     * Constructor default
     */
    public Arbol() {
        izq = null;
        der = null;
    }

    /**
     * Constructor general
     * @param izq arbol izquierdo
     * @param hoja hoja arbol
     * @param fruto fruto arbol
     * @param der arbol derecho
     */
    public Arbol(Arbol izq, Hoja hoja, Fruto fruto, Arbol der) {
        this.izq = izq;
        this.der = der;
        this.hoja = hoja;
        this.fruto = fruto;
    }

    /**
     *
     * @return arbol izquierdo
     */
    public Arbol getIzq() {
        return izq;
    }

    /**
     *
     * @param izq introducir arbol izquierdo
     */
    public void setIzq(Arbol izq) {
        this.izq = izq;
    }

    /**
     *
     * @return arbol derecho
     */
    public Arbol getDer() {
        return der;
    }

    /**
     *
     * @param der introducir arbol derecho
     */
    public void setDer(Arbol der) {
        this.der = der;
    }

    /**
     *
     * @return hoja arbol
     */
    public Hoja getHoja() {
        return hoja;
    }

    /**
     *
     * @param hoja introducir hoja arbol
     */
    public void setHoja(Hoja hoja) {
        this.hoja = hoja;
    }

    /**
     *
     * @return fruto arbol
     */
    public Fruto getFruto() {
        return fruto;
    }

    /**
     *
     * @param fruto introducir fruto arbol
     */
    public void setFruto(Fruto fruto) {
        this.fruto = fruto;
    }

    /**
     *
     * @return toString arbol
     */
    public String toString() {
        return ("Arbol " + this.fruto.toString() + " " + this.hoja.toString() + "\n");
    }
}
