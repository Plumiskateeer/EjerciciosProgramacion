package capitulo05.bloque07;

import java.util.Arrays;

public class Ejercicio05_RemoveInteger {
    public static void main(String[] args) {
        int[] matriz = new int[10];
        Ejercicio01_ArrayToString.inicializarMatriz(matriz);
        System.out.println("Array original\n" + Arrays.toString(matriz));
        int num = 4;
        System.out.println("Matriz sin el numero " + num);
        matriz = removeInteger(matriz, num);
        System.out.println("Array editada\n" + Arrays.toString(matriz));
    }

    public static int[] removeInteger(int[] matriz, int borrar){
        int[] aux = Arrays.copyOf(matriz, matriz.length - Ejercicio04_CountOcurrences.countOcurrences(matriz, borrar));

        int pos = 0;
        for (int i = 0; i < matriz.length; i++)
            if (matriz[i] != borrar)
                aux[pos++] = matriz[i];

        return aux;
    }
}
