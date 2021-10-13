package capitulo02.bloque01;

import javax.swing.*;

public class Ejercicio05_MayorMenor {

    public static void main(String[] args) {
        int[] numeros = new int[5];

        for (int i = 0; i < numeros.length; i++) {
            String str = JOptionPane.showInputDialog("Introduzca un número entero: ");
            numeros[i] = Integer.parseInt(str);
        }
        int menor = 100;
        int mayor = 0;
        for (int numero : numeros) {
            if (numero < menor) menor = numero;
            if (numero > mayor) mayor = numero;
        }

        System.out.println("El numero menor es: " + menor + "\nEl numero mayor es + " + mayor);
    }

}
