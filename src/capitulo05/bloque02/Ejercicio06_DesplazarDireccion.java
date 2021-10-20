package capitulo05.bloque02;

import javax.swing.*;

public class Ejercicio06_DesplazarDireccion {
    public static void main(String[] args) {
        int[] matriz = new int[5];

        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = (int) (Math.round(Math.random() * (100)));
            System.out.print(matriz[i] + " ");
        }
        System.out.println();

        int salvar;
        int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de desplazamientos: "));
        int desp = Integer.parseInt(JOptionPane.showInputDialog("Hacia la izquierda (0) Hacia la derecha (1): "));


        if (desp == 1) {
            for (int j = 0; j < num; j++) { // hacia la derecha se desplaza num veces
                salvar = matriz[matriz.length - 1];
                for (int i = matriz.length - 1; i >= 0; i--) {
                    if ((i - 1) >= 0)
                        matriz[i] = matriz[i - 1];
                }
                matriz[0] = salvar;
            }
        } else {
            for (int j = 0; j < (matriz.length - num); j++) { // hacia la izquierda se desplaza matriz.length - num veces, da la vuelta
                salvar = matriz[matriz.length - 1];
                for (int i = matriz.length - 1; i >= 0; i--) {
                    if ((i - 1) >= 0)
                        matriz[i] = matriz[i - 1];
                }
                matriz[0] = salvar;
            }
        }

        for (int i : matriz)
            System.out.print(i + " ");
    }
}
