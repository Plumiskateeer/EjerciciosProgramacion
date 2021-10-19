package capitulo05.bloque01;

import java.util.Random;

public class Ejercicio01_SumMedMayMen100 {
    public static void main(String[] args) {
        int[] matriz = new int[150];

        Random rnd = new Random();
        int suma = 0;
        int menor = 101;
        int mayor = 0;

        System.out.println("El array es: ");

        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = rnd.nextInt(100) + 1;
            suma += matriz[i];
            if (matriz[i] < menor) menor = matriz[i];
            if (matriz[i] > mayor) mayor = matriz[i];
            System.out.print(matriz[i] + " ");
        }
        System.out.println("La suma de sus elementos es: " + suma + "\n" +
                "La media de sus elementos es: " + ((float) suma / matriz.length) + "\n" +
                "El menor es: " + menor + "\n" +
                "El mayor es: " + mayor + "\n");

    }
}
