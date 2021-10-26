package capitulo05.bloque03;

public class Ejercicio04_Seleccion {
    public static void main(String[] args) {
        int[] matriz = new int[150];

        // inicializo e imprimo
        System.out.println("Matriz original: ");
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = (int) (Math.round(Math.random() * (1000)));
            System.out.print(matriz[i] + " ");
        }

        // recorro la matriz quedandome con el elemento inicial, avanzando de uno en uno
        for (int i = 0; i < matriz.length; i++) {
            int menor = matriz[i];
            int indice = i;
            for (int j = i; j < matriz.length; j++) { // recorro desde ese valor en adelante buscando el siguiente menor a ese
                if (matriz[j] < menor) {
                    menor = matriz[j]; // guardo su valor
                    indice = j; // guardo la posicion en la q lo he encontrado
                }
            }
            matriz[indice] = matriz[i]; //sustituyo en esa posicion el numero que guarde al principio
            matriz[i] = menor; // pongo al principio el numero menor encontrado
        }

        // imprimo la solucion
        System.out.println("\nMatriz ordenada: ");
        for (int i : matriz)
            System.out.print(i + " ");

    }
}
