package capitulo04.bloque0.batalla;

public class Alien extends CaracteristicasSoldado {

    public Alien(){
        super();
    }

    public Alien(int puntosVida, int puntosFuerza, float porcentajeAcierto) {
        super(puntosVida, puntosFuerza, porcentajeAcierto);
    }

    @Override
    public String toString() {
        return "A->" + super.toString();
    }
}
