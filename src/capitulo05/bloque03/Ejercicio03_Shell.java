package capitulo05.bloque03;

public class Ejercicio03_Shell {
    public static void main(String[] args) {
        int[] matriz = new int[150];

        // inicializo e imprimo
        System.out.println("Matriz original: ");
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = (int) (Math.round(Math.random() * (1000)));
            System.out.print(matriz[i] + " ");
        }


        // voy llamando al metodo que ordena pasandole el tamaño de intervalo y
        // disminuyendo el tamaño de ese intervalo
        int[] intervalos = {5, 4, 3, 2, 1};
        for (int i : intervalos) {
            for (int j = 0; j < i; j++)
                ordenarShell(matriz, i, j);
        }

        // imprimo el resultado
        System.out.println("\nMatriz ordenada: ");
        for (int i : matriz) {
            System.out.print(i + " ");
        }
    }

    // metodo auxiliar para ordenar segun el algoritmo shell
    public static void ordenarShell(int[] matriz, int n, int m) {
        int actual;
        for (int i = n + m; i < matriz.length; i += n) { // empiezo desde el valor del intervalo + la posicion en la que estoy
            actual = matriz[i]; // me guardo el actual
            int j;
            // recorro desde i hasta el intervalo o hasta que el elemento de la pos j-n sea mayor que el que tenia
            for (j = i; j >= n && matriz[j - n] > actual; j -= n) {
                matriz[j] = matriz[j - n]; // lo sustituyo
            }
            matriz[j] = actual; // dejo el actual en esa posicion
        }
    }
}
