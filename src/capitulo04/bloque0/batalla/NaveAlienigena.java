package capitulo04.bloque0.batalla;

public class NaveAlienigena {
    private Alien[] tripulantesAlienigenas;
    private int potenciaFuego;

    public NaveAlienigena(int numTripulantes) {
        tripulantesAlienigenas = new Alien[numTripulantes];
        for (int i = 0; i < tripulantesAlienigenas.length - 1; i++) {
            int puntosFuerza = (int) Math.round(Math.random() * 20);
            int puntosVida = (int) Math.round(Math.random() * 100);
            float porcentajeAcierto = (float) Math.round(Math.random() * (70 - 50)) + 50;
            tripulantesAlienigenas[i] = new Alien(puntosVida, puntosFuerza, porcentajeAcierto);
        }
        tripulantesAlienigenas[tripulantesAlienigenas.length - 1] = new Alien(1000, 100, 80);
    }

    public NaveAlienigena(Alien[] tripulantesAlienigenas, int potenciaFuego) {
        this.tripulantesAlienigenas = tripulantesAlienigenas;
        this.potenciaFuego = potenciaFuego;
    }

    public Alien[] getTripulantesAlienigenas() {
        return tripulantesAlienigenas;
    }

    public void setTripulantesAlienigenas(Alien[] tripulantesAlienigenas) {
        this.tripulantesAlienigenas = tripulantesAlienigenas;
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
        sb.append("Nave alienigena: ");
        for (int i = 0; i < tripulantesAlienigenas.length; i++) {
            sb.append(tripulantesAlienigenas[i].toString() + " ");
        }
        sb.append("\n");
        return sb.toString();
    }
}
