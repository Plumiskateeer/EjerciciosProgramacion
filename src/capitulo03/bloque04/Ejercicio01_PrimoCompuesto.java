package capitulo03.bloque04;

import javax.swing.*;

public class Ejercicio01_PrimoCompuesto {
    public static void main(String[]args){

        int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero para decir si es primo o compuesto: "));

        boolean esPrimo = true;

        int i = 2;
        while(i<=num/2 && esPrimo){
            if(num%i==0)
                esPrimo = false;
            i++;
        }

        if(esPrimo) System.out.println("El numero " + num + " es primo.");
        else System.out.println("El numero " + num + " no es primo.");

    }
}
