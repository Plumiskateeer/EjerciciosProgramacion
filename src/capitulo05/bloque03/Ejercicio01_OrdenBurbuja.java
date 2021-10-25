package capitulo05.bloque03;

public class Ejercicio01_OrdenBurbuja {
    public static void main(String[] args) {
        int[] matriz = new int[150];

        // inicializo e imprimo
        System.out.println("Matriz original: ");
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = (int) (Math.round(Math.random() * (1000)));
            System.out.print(matriz[i] + " ");
        }

        int cont = 0;
        while(cont < matriz.length) {
            for (int i = 0; i < matriz.length; i++) {
                if ((i + 1) < matriz.length && matriz[i] > matriz[i + 1]) {
                    // aqui copio la matriz resultante del metodo intercambiaConSiguiente en matriz, que es la original
                    System.arraycopy(intercambiaConSiguiente(i, matriz), 0, matriz, 0, matriz.length);
                    cont = 0;
                }else cont++;
            }
        }

        //imprimo resultado
        System.out.println("\nMatriz ordenada: ");
        for(int i : matriz){
            System.out.print(i+ " ");
        }
    }

    // metodo auxiliar que me intercambia el elemento en pos por el elemento de la posicion siguiente
    public static int[] intercambiaConSiguiente(int pos, int[] matriz) {
        int pos2 = pos++;
        int aux = matriz[pos];
        matriz[pos] = matriz[pos2];
        matriz[pos2] = aux;
        return matriz;
    }
}
