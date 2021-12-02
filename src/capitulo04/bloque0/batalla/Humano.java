package capitulo04.bloque0.batalla;

public class Humano extends CaracteristicasSoldado {

    public Humano(int puntosVida, int puntosFuerza, float porcentajeAcierto) {
        super(puntosVida, puntosFuerza, porcentajeAcierto);
    }

    @Override
    public String toString() {
        return "H->" + super.toString();
    }
}
