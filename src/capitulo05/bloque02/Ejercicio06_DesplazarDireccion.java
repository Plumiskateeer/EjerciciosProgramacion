package capitulo05.bloque02;

import javax.swing.*;

public class Ejercicio06_DesplazarDireccion {
    public static void main(String[] args) {
        int[] matriz = new int[5];
        int salvar;
        int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de desplazamientos: "));
        int desp = Integer.parseInt(JOptionPane.showInputDialog("Hacia la izquierda (0) Hacia la derecha (1): "));

        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = (int) (Math.round(Math.random() * (100)));
            System.out.print(matriz[i] + " ");
        }
        System.out.println();

        // string que indica resultado
        String direccion = "Desplazamiento " + num + " veces a la derecha";
        // si pide hacia la izquierda se desplaza matriz.length - num veces, es circular
        // si pide hacia la derecha se deja tal cual
        if (desp == 0) {
            direccion = "Desplazamiento " + num + " veces a la izquierda";
            num = matriz.length - num;
        }

        // este metodo es el encargado de desplazar la matriz
        for (int j = 0; j < num; j++) { // hacia la derecha se desplaza num veces
            salvar = matriz[matriz.length - 1];
            for (int i = matriz.length - 1; i >= 0; i--) {
                if ((i - 1) >= 0)
                    matriz[i] = matriz[i - 1];
            }
            matriz[0] = salvar;
        }

        System.out.println(direccion);
        // imprimo solucion
        for (int i : matriz)
            System.out.print(i + " ");
    }
}
