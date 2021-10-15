package capitulo03.bloque04;

import javax.swing.*;

public class Ejercicio05_Factorial {
    public static void main(String[]args){

        int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero para calcular el factorial: "));

        int resultado = 1;
        while(num>0){
            resultado = resultado*num;
            num--;
        }
        System.out.println("El factorial es: " + resultado);
    }
}
