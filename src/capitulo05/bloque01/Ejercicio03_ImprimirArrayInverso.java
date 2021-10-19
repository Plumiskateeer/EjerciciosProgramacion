package capitulo05.bloque01;

import java.util.Random;

public class Ejercicio03_ImprimirArrayInverso {
    public static void main(String[] args) {
        int[] matriz = new int[150];

        Random rnd = new Random();

        System.out.println("El array es: ");

        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = rnd.nextInt(100) + 1;
            System.out.print(matriz[i] + " ");
        }
        System.out.println("\nEl orden inverso es:");
        for (int i = matriz.length - 1; i >= 0; i--) {
            System.out.print(matriz[i] + " ");
        }
    }
}
