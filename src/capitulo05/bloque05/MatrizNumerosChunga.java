package capitulo05.bloque05;

import javax.swing.*;

public class MatrizNumerosChunga {
    public static void main(String[] args){

        int tam = Integer.parseInt(JOptionPane.showInputDialog("Introduce el tamaño de la matriz"));

        int [] matriz = new int[tam*tam];

        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = i+1;
        }


    }
}
