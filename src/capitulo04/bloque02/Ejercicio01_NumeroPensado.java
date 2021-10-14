package capitulo04.bloque02;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio01_NumeroPensado {
    public static void main(String[] args) {

        numeroPensado();
    }

    /**
     * Calculo del numero pensado por el ordenador, usuario introduce datos hasta adivinarlo,
     * devuelve mensaje por pantalla
     */
    public static void numeroPensado() {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);


        int nElegido = rnd.nextInt(100) + 1;
        int prediccion;


        do {
            System.out.println("Introduce un numero para adivinar el numero: (entre 0 y 100) ");
            prediccion = sc.nextInt();

            if (prediccion != nElegido) {
                if (prediccion < nElegido) {
                    System.out.println("El numero pensado es mayor al introducido. Sigue intendolo. ");
                } else System.out.println("El numero pensado es menor al introducido. Sigue intentandolo. ");
            } else System.out.println("El numero introducido es el introducido. FELICIDADES!!!!!.");

        } while (prediccion != nElegido);
    }
}
