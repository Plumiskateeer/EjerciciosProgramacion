package capitulo04.bloque01;

import java.util.Random;
import java.util.Scanner;

public class Utils {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //System.out.println("La media es: " + EJ1_media(pedirInt(),pedirInt(),pedirInt(),pedirFloat()));

        //System.out.println("Introduce los limites maximo y minimo: ");

        //ej4_5deFibonacci();

        //System.out.println("Numero impar entre 11 y 23: " + ej6_ImparEntre11y23());

        //ej7_100recursivo(1);

        System.out.println("Introduce un numero para convertirlo a string: ");
        int n = sc.nextInt();

        System.out.println(ej8_InttoString(n));

        ej9_enOrdenAscendente(5, 4, 3);
        ej9_enOrdenAscendente(3, 2, 6);
        ej9_enOrdenAscendente(4, 6, 2);
    }

    /**
     *
     * @return devuelve un int introducido
     */
    public static int pedirInt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        return sc.nextInt();
    }

    /**
     *
     * @return devuelve un float introducido
     */
    public static float pedirFloat() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        return sc.nextFloat();
    }

    /**
     *
     * @param a int
     * @param b int
     * @param c int
     * @param f float
     * @return devuelve la media de los numeros dados
     */
    public static float ej1_Media(int a, int b, int c, float f) {
        return (a + b + c + f) / 4;
    }

    /**
     *
     * @param min limite inferior
     * @param max limite superior
     */
    public static void ej2_Minmax(int min, int max) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero mayor que " + min + " y menor que " + max + " : ");
        int valor = sc.nextInt();
    }

    /**
     * Calculo del mayor de 2 numeros
     */
    public static void ej3_Mayorde2Num() {
        int n1 = pedirInt();
        int n2 = pedirInt();

        if (n1 < n2) System.out.println("El mayor es " + n2);
        else System.out.println("El mayor es " + n1);

    }
    /*
    Calculo de 5 elementos siguientes de fibonacci a partir del elemento dado
     */
    public static void ej4_5deFibonacci() {
        int n1 = pedirInt();
        int n2 = pedirInt();
        System.out.println("Los 5 siguientes numeros de fibonacci son: ");
        fibonacci(n1, n2);
    }
    /*
    Calculo de n elementos siguientes, dados 2 numeros pertenecientes a la sucesion
     */
    public static void ej5_ndeFibonacci() {
        int n1 = pedirInt();
        int n2 = pedirInt();
        int num = pedirInt();
        System.out.println("Los " + num + " siguientes numeros de fibonacci son: ");
        fibonacciN(n1, n2, num);
    }

    //este no me sale
    public static int ej6_ImparEntre11y23() {
        Random rnd = new Random();
        int numeropedido = rnd.nextInt(13) + 12;
        return (((numeropedido * 2) - 1) / 2) + 1;
    }

    /**
     *
     * @param n int
     * @return Impresion de numeros dado n hasta llegar a 100, ej: -5,-4,-3.......,98,99,100; n = -5
     */
    public static int ej7_100recursivo(int n) {
        if (n < 101) {
            System.out.println(" " + n);
            return ej7_100recursivo(n + 1);
        } else return n;
    }

    /**
     *
     * @param n numero a convertir
     * @return numero introducido en String
     */
    public static String ej8_InttoString(int n) {

        return switch (n) {
            case 1 -> "uno";
            case 2 -> "dos";
            case 3 -> "tres";
            case 4 -> "cuatro";
            case 5 -> "cinco";
            case 6 -> "seis";
            case 7 -> "siete";
            case 8 -> "ocho";
            case 9 -> "nueve";
            case 10 -> "diez";
            default -> throw new IllegalStateException("Unexpected value: " + n);
        };
    }

    /**
     *Devuelve estos numeros ordenados ascendentemente
     * @param n int
     * @param n2 int
     * @param n3 int
     */
    public static void ej9_enOrdenAscendente(int n, int n2, int n3) {
        if ((n - n2) >= 0 && (n - n3) >= 0) {
            System.out.println(n + " ");
            ej9_auxOrdena2Ascendente(n2, n3);
        } else if ((n2 - n) >= 0 && (n2 - n) >= 0) {
            System.out.println(n2 + " ");
            ej9_auxOrdena2Ascendente(n, n3);
        } else {
            System.out.println(n3 + " ");
            ej9_auxOrdena2Ascendente(n, n2);
        }
    }

    /**
     *  Devuelve los numeros introducidos ordenados ascendentemente
     * @param n int
     * @param n2 int
     * @param n3 int
     */
    public static void ej9_enOrdenDescendente(int n, int n2, int n3) {
        if ((n - n2) <= 0 && (n - n3) <= 0) {
            System.out.println(n + " ");
            ej9_auxOrdena2Descendente(n2, n3);
        } else if ((n2 - n) <= 0 && (n2 - n) <= 0) {
            System.out.println(n2 + " ");
            ej9_auxOrdena2Descendente(n, n3);
        } else {
            System.out.println(n3 + " ");
            ej9_auxOrdena2Descendente(n, n2);
        }
    }

    /***
     * Funcion auxiliar para ordenar 2 ascendentemente
     * @param n primer numero
     * @param n1 segundo numero
     */
    public static void ej9_auxOrdena2Ascendente(int n, int n1) {
        if (n < n1) System.out.print(n + " " + n1 + "\n");
        else System.out.print(n1 + " " + n + "\n");
    }

    /**
     * Funcion auxiliar para ordenar 2 descendentemente
     * @param n primer numero
     * @param n1 segundo numero
     */
    public static void ej9_auxOrdena2Descendente(int n, int n1) {
        if (n > n1) System.out.print(n + " " + n1 + "\n");
        else System.out.print(n1 + " " + n + "\n");
    }

    //FUNCIONES AUXILIARES

    /**
     * Metodo revursivo del calculo de fibonacci
     * @param n int
     * @return llamada recursiva del metodo con n-1 sumado con la llamada al metodo con n-2
     */
    public static int fibonacciOriginal(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        } else return fibonacciOriginal(n - 1) + fibonacciOriginal(n - 2);
    }

    /**
     * Calculo iterativo de fibonacci dados 2 elementos
     * @param n1 primer elemento
     * @param n2 segundo elemento
     */
    public static void fibonacci(int n1, int n2) {
        for (int i = 0; i < 5; i++) {
            int nextElem = n1 + n2;
            System.out.println(nextElem + " ");
            n1 = n2;
            n2 = nextElem;
        }
    }

    public static void fibonacciN(int n1, int n2, int rep) {
        for (int i = 0; i < rep; i++) {
            int nextElem = n1 + n2;
            System.out.println(nextElem + " ");
            n1 = n2;
            n2 = nextElem;
        }
    }

}
