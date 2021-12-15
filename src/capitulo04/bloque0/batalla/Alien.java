package capitulo04.bloque0.batalla;

public class Alien extends Personaje {

    public Alien(){
        super();
    }

    public Alien(int puntosVida, int puntosFuerza, float porcentajeAcierto) {
        super(puntosVida, puntosFuerza, porcentajeAcierto);
    }

    @Override
    public String toString() {
        if(this.getPuntosVida() > 0)
            return "[A: " + this.getPuntosVida() + " ]";
        else return "[A:X]";
    }
}
