package capitulo04.bloque04.Ejercicio03_Arbol;

public class Arbol {
    private Arbol izq, der;
    private Hoja hoja;
    private Fruto fruto;

    public Arbol() {
        izq = null;
        der = null;
    }

    public Arbol(Arbol izq, Hoja hoja, Fruto fruto, Arbol der) {
        this.izq = izq;
        this.der = der;
        this.hoja = hoja;
        this.fruto = fruto;
    }

    public Arbol getIzq() {
        return izq;
    }

    public void setIzq(Arbol izq) {
        this.izq = izq;
    }

    public Arbol getDer() {
        return der;
    }

    public void setDer(Arbol der) {
        this.der = der;
    }

    public Hoja getHoja() {
        return hoja;
    }

    public void setHoja(Hoja hoja) {
        this.hoja = hoja;
    }

    public Fruto getFruto() {
        return fruto;
    }

    public void setFruto(Fruto fruto) {
        this.fruto = fruto;
    }

    public String toString() {
        return ("Arbol " + this.fruto.toString() + " " + this.hoja.toString() + "\n");
    }
}
