package capitulo01.bloque01;

public class RotarArraySentidoReloj {
    public static void main(String[] args) {
        int[][] matriz = new int[5][5];

        inicializarMatriz(matriz);
        System.out.println("Matriz original: ");
        imprimirMatriz(matriz);
        int [][] rotada = rotar90Grados(matriz);
        System.out.println("Matriz rotada: ");
        imprimirMatriz(rotada);
    }

    public static void inicializarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = (int) (Math.round(Math.random() * 10));
            }
        }
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] rotar90Grados(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        int[][] aux = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                aux[i][j] = matriz[filas - j - 1][i];
            }
        }
        return aux;
    }
}
