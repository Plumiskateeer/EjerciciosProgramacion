package examenes.examen03122021;


public class Ejercicio01_EstaOrdenado {
    public static void main(String[] args) {
        int[][] matriz = new int[4][4];
        System.out.println("La matriz es: ");
        inicializarMatriz(matriz);

        if (estaLaMatrizOrdenada(matriz)) {
            System.out.println("La matriz esta ordenada");
        } else System.out.println("La matriz no esta ordenada");
    }

    public static void inicializarMatriz(int[][] matriz) {
        int k = 1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = k++;
//                if(i==2 && j == 2)        // este codigo comprueba que estando desordenada muestra correctamente que esta desordenada
//                    matriz[i][j] = 59;    // NO DESCOMENTAR
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean estaLaMatrizOrdenada(int[][] matriz) {
        boolean estaOrdenada = true;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (i + 1 < matriz.length && j + 1 < matriz.length && matriz[i][j] > matriz[i + 1][j + 1])
                    estaOrdenada = false;
            }
        }
        return estaOrdenada;
    }
}
