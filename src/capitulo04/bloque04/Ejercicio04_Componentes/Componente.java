package capitulo04.bloque04.Ejercicio04_Componentes;

public class Componente {
    private Componente izq, der;

    /**
     *
     */
    public Componente(){
        this.izq = null;
        this.der = null;
    }

    /**
     *
     * @param izq
     * @param der
     */
    public Componente(Componente izq, Componente der){
        this.izq = izq;
        this.der = der;
    }

}
