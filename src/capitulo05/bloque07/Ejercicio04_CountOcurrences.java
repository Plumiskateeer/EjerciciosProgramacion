package capitulo05.bloque07;

import java.util.Arrays;

public class Ejercicio04_CountOcurrences {
    public static void main(String[] args) {
        int[] matriz = new int[10];
        Ejercicio01_ArrayToString.inicializarMatriz(matriz);
        System.out.println("Array original\n" + Arrays.toString(matriz));
        int num = 6;
        System.out.println("El numero " + num + " aparece " + countOcurrences(matriz, num) + " en la matriz");
    }

    public static int countOcurrences(int[] matriz, int num) {
        int cont = 0;
        for (int i : matriz)
            if (i == num)
                cont++;

        return cont;
    }
}
