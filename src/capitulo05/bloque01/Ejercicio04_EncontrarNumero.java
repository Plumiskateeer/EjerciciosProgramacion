package capitulo05.bloque01;

import javax.swing.*;
import java.util.Random;

public class Ejercicio04_EncontrarNumero {
    public static void main(String[] args) {
        int[] matriz = new int[150];

        Random rnd = new Random();

        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = rnd.nextInt(100) + 1;
        }

        int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero a buscar: "));

        int[] posiciones = new int[matriz.length];
        boolean encontrado = false;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i] == num) {
                posiciones[i]++;
                encontrado = true;
            }
        }
        if (encontrado) {
            System.out.println("El numero está en las posiciones: ");
            for (int i = 0; i < posiciones.length; i++) {
                if (posiciones[i] == 1)
                    System.out.print(i + " ");
            }
        } else System.out.println("El numero NO ESTA en la matriz");

    }

}
