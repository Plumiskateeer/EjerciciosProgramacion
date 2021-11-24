package capitulo05.bloque07;

import java.util.Arrays;

public class Ejercicio03_AddInteger {
    public static void main(String[] args) {
        int[] matriz = new int[10];
        Ejercicio01_ArrayToString.inicializarMatriz(matriz);
        System.out.println("Array original\n" + Arrays.toString(matriz));
        matriz = addInteger(matriz,5);
        System.out.println("Array editado\n" + Arrays.toString(matriz));
    }

    public static int[] addInteger(int[] matriz, int num) {
        int[] nueva = Arrays.copyOf(matriz, matriz.length + 1);
        nueva[matriz.length] = num;
        return nueva;
    }
}
