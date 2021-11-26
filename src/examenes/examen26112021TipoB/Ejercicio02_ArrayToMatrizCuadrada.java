package examenes.examen26112021TipoB;

public class Ejercicio02_ArrayToMatrizCuadrada {
    public static void main(String[] args) {
        int longitud = (int) (Math.round(Math.random() * 8) + 2);
        int[] array = new int[longitud * longitud];
        Ejercicio01_MediaArrays.inicializarArray(array, 10, 0);
        System.out.println("Array inicial");
        Ejercicio01_MediaArrays.imprimirArray(array);
        int[][] matriz = arrayToMatriz(array, longitud);
        System.out.println("\n Matriz " + longitud + " * " + longitud + " tras transformar el array");
        imprimirMatriz(matriz);

    }

    public static int[][] arrayToMatriz(int[] array, int longitud) {
        int[][] matriz = new int[longitud][longitud];
        int k = 0;
        for (int i = 0; i < longitud; i++) {
            for (int j = 0; j < longitud; j++) {
                matriz[i][j] = array[k];
                k++;
            }
        }
        return matriz;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
