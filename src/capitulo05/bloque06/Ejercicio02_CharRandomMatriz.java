package capitulo05.bloque06;

public class Ejercicio02_CharRandomMatriz {
    public static void main(String[] args) {

        char[][] cadenasChar = new char[10][30];

        inicializarMatriz(cadenasChar);
        imprimirMatriz(cadenasChar);
    }

    public static void imprimirMatriz(char[][] matriz) {
        for (char[] i : matriz) {
            for (char c : i)
                System.out.print(c + " ");
            System.out.println();
        }
    }

    public static void inicializarMatriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            int num = (int) (Math.round(Math.random() * 30));
            for (int j = 0; j < num; j++) {
                matriz[i][j] = '*';
            }
            for (int j = num; j < matriz[0].length; j++) {
                matriz[i][j] = ' ';
            }
        }
    }
}
