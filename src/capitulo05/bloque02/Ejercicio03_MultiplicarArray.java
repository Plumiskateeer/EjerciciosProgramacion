package capitulo05.bloque02;

import javax.swing.*;

public class Ejercicio03_MultiplicarArray {
    public static void main(String[] args){
        int[] matriz = new int[150];

        // inicializo e imprimo
        System.out.println("Matriz original");
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = (int) Math.round(Math.random() * (100));
            System.out.print(matriz[i] + " ");
        }
        // pido num al usuario
        int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero para multiplicar el array: "));

        // multiplico toda la matriz e imprimo
        System.out.println("\nMatriz multiplicada por " + num);
        for(int i : matriz){
            i *= num;
            System.out.print( i+ " ");
        }


    }
}
