package capitulo05.bloque03;

public class Ejercicio02_InsercionDirecta {
    public static void main(String[] args) {
        int[] matriz = new int[150];

        // inicializo e imprimo
        System.out.println("Matriz original: ");
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = (int) (Math.round(Math.random() * (1000)));
            System.out.print(matriz[i] + " ");
        }

        // realizo el cambio con insercion directa
        for (int i = 1; i < matriz.length; i++) {
            int actual = matriz[i];
            int j;
            for (j = i; j > 0 && matriz[j - 1] > actual; j--) {
                matriz[j] = matriz[j - 1];
            }
            matriz[j] = actual;
        }

        // imprimo el resultado

        System.out.println("\nMatriz ordenada: ");
        for (int i : matriz)
            System.out.print(i + " ");
    }
}
