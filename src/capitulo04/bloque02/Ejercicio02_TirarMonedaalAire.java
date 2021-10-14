package capitulo04.bloque02;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio02_TirarMonedaalAire {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String opcion;
        int puntos = 0;

        do {
            // CARA = 1, CRUZ = 0
            System.out.println("Elige (cara) o (cruz): (stop para salir)");
            opcion = sc.nextLine();

            if (CaraoCruz() == 1 && opcion.equals("cara")) {
                System.out.println("Has acertado CARA.");
                puntos++;
            } else if (CaraoCruz() == 0 && opcion.equals("cruz")) {
                System.out.println("Has acertado CRUZ.");
                puntos++;
            }

        } while (!opcion.equals("stop"));

        System.out.println("Has obtenido " + puntos + " puntos");

    }

    /**
     * Calculo de num aleatorio 0 o 1
     * @return 0/1
     */
    public static int CaraoCruz() {
        Random rnd = new Random();
        return rnd.nextInt(2);
    }
}
