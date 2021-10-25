package capitulo05.bloque02;

import javax.swing.*;
import java.util.jar.JarOutputStream;

public class Ejercicio05_DesplazarUsuario {
    public static void main(String[] args) {
        int[] matriz = new int[5];

        // inicializo e imprimo
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = (int) (Math.round(Math.random() * (100)));
            System.out.print(matriz[i] + " ");
        }
        System.out.println();

        int ultimo;
        int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de desplazamientos: ")); // pido num

        // realizo la rotacion
        for (int j = 0; j < num; j++){
            ultimo = matriz[matriz.length - 1];
            for (int i = matriz.length - 1; i >= 0; i--) {
                if ((i - 1) >= 0)
                    matriz[i] = matriz[i - 1];
            }
            matriz[0] = ultimo;
        }

        // imprimo resultado
        for (int i : matriz)
            System.out.print(i + " ");
    }
}
