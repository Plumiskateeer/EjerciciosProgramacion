package capitulo05.bloque02;

import javax.swing.*;

public class Ejercicio03_MultiplicarArray {
    public static void main(String[] args){
        int[] m1 = new int[150];

        System.out.println("Matriz original");
        for (int i = 0; i < m1.length; i++) {
            m1[i] = (int) Math.round(Math.random() * (100));
            System.out.print(m1[i] + " ");
        }

        int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero para multiplicar el array: "));

        for(int i = 0; i < m1.length; i++){
            m1[i] *= num;
        }
        System.out.println("\nMatriz multiplicada por " + num);
        for(int i : m1){
            System.out.print(i + " ");
        }
    }
}
