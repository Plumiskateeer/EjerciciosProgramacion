package examenes.examen20211021;

import javax.swing.*;

public class Ejercicio05 {
    public static void main(String[] args){

        // el usuario introduce un digito
        int digito = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero: "));
        for (int i = 0; i < 100; i++) {
            int num = (int)(Math.round(Math.random()*(100))); // genero el num aleatorio
            // si el numero coincide o si el num es mayor de 10 y tiene de resto entre 10 el digito
            // se cumple esta condicion y lo imprime con mensaje, si no simplemente lo imprime
            if(num == digito || (num > 10 && num%10 == digito))
                System.out.println(num + " Este numero termina en el digito " + digito);
            else System.out.println(num);

        }
    }
}
