package examenes.examen03122021;

public class Ejercicio02_DesordenarArray {
    public static void main(String[] args) {
        int[] array = new int[5];
        inicializarArray(array);
        imprimirArray(array);
        int[] desordenado = desordenarArray(array);
        System.out.println();
        imprimirArray(desordenado);

    }

    public static void inicializarArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round(Math.random() * 100);
        }
    }

    public static void imprimirArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] desordenarArray(int[] array) {
        int[] nuevo = new int[array.length];
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            int pos = (int) Math.round(Math.random() * (array.length - 1));
            if (nuevo[pos] == 0) {
                nuevo[pos] = array[i];
            } else i--;
        }
        return nuevo;
    }

}
