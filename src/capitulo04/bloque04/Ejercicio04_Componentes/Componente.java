package capitulo04.bloque04.Ejercicio04_Componentes;

public class Componente {
    private Componente izq, der;

    /**
     * Constructor por defecto
     */
    public Componente(){
        this.izq = null;
        this.der = null;
    }

    /**
     * Constructor arbol
     * @param izq arbol izquierdo
     * @param der arbol derecho
     */
    public Componente(Componente izq, Componente der){
        this.izq = izq;
        this.der = der;
    }

}
