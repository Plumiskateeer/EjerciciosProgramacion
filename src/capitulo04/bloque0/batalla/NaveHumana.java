package capitulo04.bloque0.batalla;

public class NaveHumana {
    private Humano[] tripulantesHumanos;
    private int potenciaFuego;

    public NaveHumana(int numTripulantes) {
        tripulantesHumanos = new Humano[numTripulantes];
        for (int i = 0; i < tripulantesHumanos.length - 1; i++) {
            int puntosFuerza = (int) Math.round(Math.random() * 20);
            int puntosVida = (int) Math.round(Math.random() * 100);
            float porcentajeAcierto = (float) Math.round(Math.random() * (70 - 50)) + 50;
            tripulantesHumanos[i] = new Humano(puntosVida, puntosFuerza, porcentajeAcierto);
        }
        tripulantesHumanos[tripulantesHumanos.length - 1] = new Humano(1000, 100, 80);

    }

    public NaveHumana(Humano[] tripulantesHumanos, int potenciaFuego) {
        this.tripulantesHumanos = tripulantesHumanos;
        this.potenciaFuego = potenciaFuego;
    }

    public Humano[] getTripulantesHumanos() {
        return tripulantesHumanos;
    }

    public void setTripulantesHumanos(Humano[] tripulantesHumanos) {
        this.tripulantesHumanos = tripulantesHumanos;
    }

    public int getPotenciaFuego() {
        return potenciaFuego;
    }

    public void setPotenciaFuego(int potenciaFuego) {
        this.potenciaFuego = potenciaFuego;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nave humana: ");
        for (int i = 0; i < tripulantesHumanos.length; i++) {
            sb.append(tripulantesHumanos[i].toString() + " ");
        }
        sb.append("\n");
        return sb.toString();
    }
}
