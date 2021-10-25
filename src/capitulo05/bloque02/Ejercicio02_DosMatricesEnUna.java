package capitulo05.bloque02;

import java.util.Random;

public class Ejercicio02_DosMatricesEnUna {
    public static void main(String[] args) {
        int[] m1 = new int[150];
        int[] m2 = new int[150];
        int[] m3 = new int[m1.length + m2.length];

        // las inicializo
        for (int i = 0; i < m1.length; i++) {
            m1[i] = (int) Math.round(Math.random() * (100));
            m2[i] = (int) Math.round(Math.random() * (100));
        }

        // imprimo matrices
        System.out.println("Primera matriz ");
        for (int i : m1) {
            System.out.print(i + " ");
        }
        System.out.println("\nSegunda matriz ");
        for (int i : m2) {
            System.out.print(i + " ");
        }

        // realizo los cambios, los pares de la matriz 2 a la 3
        for (int i = 0; i < m1.length; i++) {
            if(i%2==0) m3[i] = m2[i];
        }
        // los impares de la matriz 1 a la 3
        for (int i = 0; i < m1.length; i++) {
            if(i%2!=0) m3[i] = m1[i];
        }
        // imprimo matriz resultante
        System.out.println("\nTercera matriz ");
        for (int i : m3) {
            System.out.print(i + " ");
        }

    }
}
