package capitulo05.bloque01;

import javax.swing.*;
import java.util.Random;

public class Ejercicio02_ArrayLimINFSUP {
    public static void main(String[] args) {

        int limInf = Integer.parseInt(JOptionPane.showInputDialog("Introduce el limite inferior del array: "));
        int limSup = Integer.parseInt(JOptionPane.showInputDialog("Introduce el limite superior del array: "));

        int[] matriz = new int[150];

        Random rnd = new Random();

        System.out.println("El array es: ");

        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = rnd.nextInt(limSup - limInf + 1) + limInf;
            System.out.print(matriz[i] + " ");
        }
    }
}
