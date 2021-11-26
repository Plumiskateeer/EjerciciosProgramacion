package examenes.examen26112021TipoB;

public class Ejercicio03_PorcentajeDebajoValorMedio {
    public static void main(String[] args) {
        int[] array = new int[100];
        Ejercicio01_MediaArrays.inicializarArray(array, 100, -100);
        System.out.println("Array inicial: ");
        Ejercicio01_MediaArrays.imprimirArray(array);
        System.out.println("El porcentaje de numeros por debajo de la media es: " + calcularPorcentajeDebajoMedia(array));
    }

    public static float calcularPorcentajeDebajoMedia(int[] array) {
        int suma = 0;
        for (int i : array)
            suma += i;

        float media = (float) suma / array.length;
        System.out.println("\nLa media es " + media);
        int cont = 0;
        for (int i : array)
            if (i < media)
                cont++;

        return (float) cont / array.length * 100;
    }
}
