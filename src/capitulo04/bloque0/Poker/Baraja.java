package capitulo04.bloque0.Poker;

import java.util.Arrays;

public class Baraja {
    private Carta[] cartas;

    public Baraja() {
        cartas = new Carta[52];
        inicializarArrayCartas(cartas);
    }

    public static void inicializarArrayCartas(Carta[] cartas) {
        String[] palos = {"corazones", "picas", "trébol", "diamante"};
        int cont = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 14; j++) {
                cartas[cont++] = new Carta(palos[i],j,cont);
            }
        }
    }

    @Override
    public String toString() {
        return "Baraja{" +
               "cartas=" + Arrays.toString(cartas) +
               '}';
    }
}
