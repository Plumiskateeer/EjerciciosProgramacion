package capitulo05.bloque02;

import javax.swing.*;

public class Ejercicio03_MultiplicarArray {
    public static void main(String[] args){
        int[] matriz = new int[150];

        System.out.println("Matriz original");
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = (int) Math.round(Math.random() * (100));
            System.out.print(matriz[i] + " ");
        }

        int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero para multiplicar el array: "));

        System.out.println("\nMatriz multiplicada por " + num);
        for(int i : matriz){
            i *= num;
            System.out.print( i+ " ");
        }


    }
}
