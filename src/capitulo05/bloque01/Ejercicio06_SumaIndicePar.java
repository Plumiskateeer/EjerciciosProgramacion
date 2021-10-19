package capitulo05.bloque01;

import java.util.Random;

public class Ejercicio06_SumaIndicePar {
    public static void main(String[] args) {
        int[] matriz = new int[150];

        Random rnd = new Random();

        int suma = 0;

        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = rnd.nextInt(100) + 1;
            if (i % 2 == 0) suma += matriz[i];
        }
        System.out.println("La suma de los indices pares es: " + suma);
    }
}
