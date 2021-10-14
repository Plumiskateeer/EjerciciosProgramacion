package capitulo04.bloque04.Ejercicio04_Componentes;

public class Bateria extends Componente{
    private int voltaje;

    public Bateria(){
        super();
        this.voltaje = 0;
    }

    public Bateria(int voltaje){
        super();
        this.voltaje = voltaje;
    }
    public int getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(int voltaje) {
        this.voltaje = voltaje;
    }
}
