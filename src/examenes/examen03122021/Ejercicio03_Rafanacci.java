package examenes.examen03122021;

public class Ejercicio03_Rafanacci {
    public static void main(String[] args) {
        float[] array = new float[10];
        inicializarConRafanacci(array);
        imprimirArray(array);
    }

    public static void imprimirArray(float[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void inicializarConRafanacci(float[] array) {
        int k = 0;
        for (float i = 0; i < array.length; i++) {
            array[k++] = rafanacci(i);
        }
    }

    public static float rafanacci(float n) {
        if (n == 1) {
            return 0.5f;
        } else if (n == 0) {
            return 1f;
        } else return rafanacci(n - 1) * rafanacci(n - 2) + rafanacci(n - 1) * 0.5f;
    }
}

