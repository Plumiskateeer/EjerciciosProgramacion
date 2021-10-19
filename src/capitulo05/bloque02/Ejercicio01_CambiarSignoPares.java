package capitulo05.bloque02;

import java.util.Random;

public class Ejercicio01_CambiarSignoPares {
    public static void main(String[] args) {
        int[] matriz = new int[150];

        Random rnd = new Random();

        System.out.println("Matriz original: ");
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = rnd.nextInt(200) - 100;
            System.out.print(matriz[i] + " ");
        }

        System.out.println("\nMatriz cambiando de signo los pares: ");
        for (int i : matriz) {
            if (i % 2 == 0) i *= (-1);
            System.out.print(i + " ");
        }

    }
}
