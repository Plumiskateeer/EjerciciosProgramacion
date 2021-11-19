package capitulo05.bloque07;

import java.util.Arrays;

public class Ejercicio02_FindAndReplace {
    public static void main(String[] args){
        int[]  matriz = new int[10];
        Ejercicio01_ArrayToString.inicializarMatriz(matriz);
        System.out.println("Array original\n" + Arrays.toString(matriz));
        findAndReplace(matriz,3,4);
        System.out.println("Array editado\n" + Arrays.toString(matriz));

    }

    public static void findAndReplace(int[] numeros, int buscar, int reemplazar){
        for (int i = 0; i < numeros.length; i++) {
            if(numeros[i] == buscar)
                numeros[i] = reemplazar;
        }
    }
}
