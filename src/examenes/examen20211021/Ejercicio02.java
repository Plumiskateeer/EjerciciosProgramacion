package examenes.examen20211021;

import javax.swing.*;

public class Ejercicio02 {
    public static void main(String[] args) {
        // declaro variables y seguidamente pido datos al usuario,
        // si introduce datos incorrectos los pide de nuevo
        int limInf, limSup;

        do {
            limInf = Integer.parseInt(JOptionPane.showInputDialog("Introduce el limite inferior (negativo): "));
            limSup = Integer.parseInt(JOptionPane.showInputDialog("Introduce el limite superior (positivo): "));
        } while (limInf > 0 || limSup < 0);

        // aqui imprimo directamente 10 numeros enteros, comprendidos entre esos limites
        for (int i = 0; i < 10; i++) {
            System.out.print((int) (Math.round((Math.random() * (limSup - limInf)) + limInf)) + " ");
        }

    }
}
