package capitulo04.bloque02;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio05_LosChinos {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int propios, aciertos = 0;

        do {
            System.out.println("Introduce el numero de chinos en tu mano: (0 para salir) ");
            propios = sc.nextInt();

            System.out.println("Introduce el numero de chinos a adivinar: ");
            int prediccion = sc.nextInt();

            int chinospc = devolverNumChinos();

            if (prediccion == chinospc) {
                System.out.println("Felicidades, has acertado. Has ganado un punto.");
                aciertos++;
            } else if (propios == chinospc) {
                System.out.println("El ordenador ha acertado. Has perdido un punto.");
                aciertos--;
            } else System.out.println("Nadie ha ganado ni perdido.");

        } while (propios != 0);

        System.out.println("Tienes " + aciertos + " puntos.");
    }

    /**
     *
     * @return numero aleatorio para numero de chinos
     */
    public static int devolverNumChinos() {
        Random rnd = new Random();
        return rnd.nextInt(11) + 1;
    }
}
