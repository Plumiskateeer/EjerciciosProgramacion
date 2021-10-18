package capitulo04.bloque04.Ejercicio04_Componentes;

public class Resistencia extends Componente{
    private int ohmios;

    /**
     * Constructor por defecto
     */
    public Resistencia(){
        super();
        this.ohmios = 0;
    }

    /**
     * Constructor resistencia
     * @param ohmios valor resistencia en ohmios
     * @param izq arbol izquierdo
     * @param der arbol derecho
     */
    public Resistencia(int ohmios, Componente izq, Componente der){
        super(izq,der);
        this.ohmios = ohmios;
    }
}
