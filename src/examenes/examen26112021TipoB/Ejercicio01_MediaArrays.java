package examenes.examen26112021TipoB;

public class Ejercicio01_MediaArrays {
    public static void main(String[] args) {
        int[] array1 = new int[5];
        int[] array2 = new int[5];

        inicializarArray(array1, 100, 0);
        inicializarArray(array2, 100, 0);
        float[] medias = calcularMediaArrays(array1, array2);
        System.out.println("Primer array: ");
        imprimirArray(array1);
        System.out.println("\nSegundo array: ");
        imprimirArray(array2);
        System.out.println("\nArray con la media de su posicion respecto al otro array: ");
        imprimirArray(medias);
    }

    public static void inicializarArray(int[] array, int limSup, int limInf) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.round(Math.random() * (limSup - limInf)) + limInf);
        }
    }

    public static float[] calcularMediaArrays(int[] arr1, int[] arr2) {
        float[] nuevo = new float[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            nuevo[i] = (arr1[i] + arr2[i]) / 2.f;
        }
        return nuevo;
    }

    public static void imprimirArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void imprimirArray(float[] array) {
        for (float i : array) {
            System.out.print(i + " ");
        }
    }
}
