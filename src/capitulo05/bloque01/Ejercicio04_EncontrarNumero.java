package capitulo05.bloque01;

import javax.swing.*;
import java.util.Random;

public class Ejercicio04_EncontrarNumero {
    public static void main(String[]args){
        int [] matriz = new int[150];

        Random rnd = new Random();

        for(int i = 0; i < matriz.length; i++){
            matriz[i] = rnd.nextInt(100) + 1;
        }

        int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero a buscar: "));

        boolean encontrado = false;
        for(int i : matriz){
            if (i == num) {
                encontrado = true;
                System.out.println("El numero ESTA en la matriz");
                break;
            }
        }
        if(!encontrado) System.out.println("El numero NO ESTA en la matriz");

    }
}
