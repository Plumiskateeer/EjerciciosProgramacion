package capitulo04.bloque0.Poker;

import java.util.Arrays;

public class Baraja {
    private static Carta[] cartas;

    public Baraja() {
        cartas = new Carta[52];
        inicializarArrayCartas(cartas);
    }

    public static void inicializarArrayCartas(Carta[] cartas) {
        String[] palos = {"corazones", "picas", "trébol", "diamante"};
        int cont = 0;
        for (int i = 0; i < palos.length; i++) {
            for (int j = 2; j < 15; j++) {
                cartas[cont++] = new Carta(palos[i],j,cont);
            }
        }
    }

    public static void cartaDeAbajoArriba(){
        Carta aux = cartas[cartas.length-1];
        for (int i = cartas.length-1; i > 0; i--) {
            cartas[i] = cartas[i-1];
        }
        cartas[0] = aux;
    }

    public static void cartaDeArribaAbajo(){
        Carta aux = cartas[0];
        for (int i = 0; i < cartas.length-1; i++) {
            cartas[i] = cartas[i+1];
        }
        cartas[cartas.length-1] = aux;
    }

    @Override
    public String toString() {
        return "Baraja{" +
               "cartas=" + Arrays.toString(cartas) +
               '}';
    }
}
