package examenes.examen26112021TipoB;

import javax.swing.*;

public class Ejercicio04_BorrarElemArray {
    public static void main(String[] args) {
        int[] array = new int[10];
        Ejercicio01_MediaArrays.inicializarArray(array, 100, 0);
        System.out.println("Array inicial: ");
        Ejercicio01_MediaArrays.imprimirArray(array);
        int pos = Integer.parseInt(JOptionPane.showInputDialog("Introduce la posicion del array que desea eliminar: "));
        eliminarDeArray(array, pos);
        System.out.println("\nArray elimando elemento de la posicion " + pos + ", rotando elementos y añadiendo random al final:");
        Ejercicio01_MediaArrays.imprimirArray(array);
    }

    public static void eliminarDeArray(int[] arrayInicial, int pos) {
        for (int i = pos; i < arrayInicial.length; i++) {
            if (i + 1 < arrayInicial.length)
                arrayInicial[i] = arrayInicial[i + 1];
        }
        arrayInicial[arrayInicial.length - 1] = (int) (Math.round(Math.random() * 100));
    }
}