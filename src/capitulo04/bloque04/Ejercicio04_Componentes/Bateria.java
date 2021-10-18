package capitulo04.bloque04.Ejercicio04_Componentes;

public class Bateria extends Componente{
    private int voltaje;

    /**
     * Constructor por defecto
     */
    public Bateria(){
        super();
        this.voltaje = 0;
    }

    /**
     * Constructor general
     * @param voltaje voltaje bateria
     * @param izq componente izquierdo
     * @param der componente derecho
     */
    public Bateria(int voltaje, Componente izq, Componente der){
        super(izq, der);
        this.voltaje = voltaje;
    }

    /**
     *
     * @return voltaje bateria
     */
    public int getVoltaje() {
        return voltaje;
    }

    /**
     *
     * @param voltaje introducir voltaje
     */
    public void setVoltaje(int voltaje) {
        this.voltaje = voltaje;
    }
}
