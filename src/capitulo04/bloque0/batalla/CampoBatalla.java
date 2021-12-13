package capitulo04.bloque0.batalla;

import java.util.Arrays;

public class CampoBatalla {
    private Humano[] humanos = new Humano[5];
    private Alien[] aliens = new Alien[5];

    public CampoBatalla() {
        inicializarPersonajes(humanos);
        inicializarPersonajes(aliens);
    }

    public void inicializarPersonajes(CaracteristicasSoldado[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array instanceof Alien[])
                array[i] = new Alien();
             else array[i] = new Humano();
        }
        CaracteristicasSoldado ultimo = array[array.length - 1];
        ultimo.setPorcentajeAcierto(60);
        ultimo.setPuntosFuerza(100);
        ultimo.setPuntosVida(1000);
    }

    public Humano[] getHumanos() {
        return humanos;
    }

    public void setHumanos(Humano[] humanos) {
        this.humanos = humanos;
    }

    public Alien[] getAliens() {
        return aliens;
    }

    public void setAliens(Alien[] aliens) {
        this.aliens = aliens;
    }

    @Override
    public String toString() {
        return "CampoBatalla{" +
               "humanos=" + Arrays.toString(humanos) +
               ", aliens=" + Arrays.toString(aliens) +
               '}';
    }
}
