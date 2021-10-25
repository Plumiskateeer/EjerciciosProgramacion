package capitulo05.bloque02;

public class Ejercicio04_DesplazarArray {
    public static void main(String[] args) {
        int[] matriz = new int[5];

        System.out.println("Matriz original: ");
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = (int) (Math.round(Math.random() * (100)));
            System.out.print(matriz[i] + " ");
        }

        int ultimo = matriz[matriz.length - 1];

        for (int i = matriz.length - 1; i >= 0; i--) {
            if ((i - 1) >= 0)
                matriz[i] = matriz[i - 1];
        }
        matriz[0] = ultimo;

        System.out.println("\nMatriz rotada: ");
        for (int i : matriz)
            System.out.print(i + " ");
    }
}
