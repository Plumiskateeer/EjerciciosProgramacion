package capitulo04.bloque0.batalla;

public class Humano extends Personaje {

    public Humano(){
        super();
    }
    public Humano(int puntosVida, int puntosFuerza, float porcentajeAcierto) {
        super(puntosVida, puntosFuerza, porcentajeAcierto);
    }

    @Override
    public String toString() {
        if(this.getPuntosVida() > 0)
        return "[H: " + this.getPuntosVida() + " ]";
        else return "[H:X]";
    }
}
