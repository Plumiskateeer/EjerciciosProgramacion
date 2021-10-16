package capitulo03.bloque04;

import javax.swing.*;

public class Ejercicio02_PrimosIntervalo {
    public static void main(String[]args){
        boolean esPrimo = true;
        int i = 2;
        int limInf = Integer.parseInt(JOptionPane.showInputDialog("Introduce el limite inferior: "));
        int limSup = Integer.parseInt(JOptionPane.showInputDialog("Introduce el limite superior: "));

        while(limInf<=limSup) {
            int num = limInf;
            while (i <= num / 2 && esPrimo) {
                if (num % i == 0) {
                    esPrimo = false;
                    System.out.println("El numero " + num + " no es primo.");
                }
                i++;
            }
            i=2;
            if(esPrimo) System.out.println("El numero " + num + " es primo.");
            esPrimo = true;
            limInf++;
        }
    }
}

