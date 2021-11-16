package capitulo04.bloque02;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio03_MenuSumaMediaContadoresDesviacion {
    public static void main(String[] args) {
        //contar números positivos, negativos y nulos de 200 números en el intervalo -100, 100;
        // suma y media de 500 números en el intervalo 0,1000;
        // y mayor y menor en el intervalo 0,1000.

        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("MENU DE OPERACIONES DISPONIBLES");
            System.out.println(".------------------------------.");
            System.out.println(
                    "1. Contar numeros positivos, negativos y nulos de 200 numeros entre -100 y 100.\n" +
                    "2. Suma y media de 500 numeros en el intervalo 0-1000.\n" +
                    "3. Mayor y menor en el intervalo 0-1000.");
            System.out.println(".-------------------------------.");
            System.out.println("Elige la operacion a realizar, 0 para salir: ");
            op = sc.nextInt();

            if (op > -1 && op < 6) {

                switch (op) {
                    case 1 : System.out.println("El conteo es: \n" + contarPosNegNulos() + "\n");
                    case 2 : System.out.println("La suma y media: \n" + sumayMedia500() + "\n");
                    case 3 : System.out.println("El mayor y menor numero del intervalo 0-1000 es: \n" + mayoryMenor1000() + "\n");
                }
            } else {
                System.out.println("\nOpcion incorrecta\n");
            }
        } while (op != 0);

    }

    /**
     *  Metodo que devuelve cantidad de positivos, negativos y nulos
     * @return cantidad de numeros contados de cada tipo
     */
    public static String contarPosNegNulos() {
        int positivos = 0;
        int negativos = 0;
        int nulos = 0;

        for (int i = 0; i < 200; i++) {
            int num = numAleatorioInter100();
            if (num < 0) negativos++;
                else if (num == 0) nulos++;
                    else positivos++;
        }
        return ("Positivos: " + positivos + " Negativos: " + negativos + " Nulos: " + nulos);
    }

    /**
     *
     * @return suma y media de 500 numeros aleatorios entre  y 1000
     */
    public static String sumayMedia500() {
        int suma = 0;
        for (int i = 0; i < 500; i++) {
            suma += numAleatorioInter1000();
        }
        return ("Suma: " + suma + " Media: " + ((float) suma) / 500);
    }

    /**
     *
     * @return mayor y menor de 100 numeros al azar entre 0 y 1000
     */
    public static String mayoryMenor1000() {

        int menor = 1000;
        int mayor = 0;

        while (menor != 0 && mayor != 999) {
            int num = numAleatorioInter1000();

            if (num < menor) menor = num;
                else if (num > mayor) mayor = num;
        }

        return ("Mayor: " + mayor + " Menor: " + menor);
    }

    /**
     *
     * @return numero aleatorio entre 0 y 100
     */
    public static int numAleatorioInter100() {
        Random rnd = new Random();
        return rnd.nextInt(201)- 100;
    }

    /**
     *
     * @return numero aleatorio entre 0 y 1000
     */
    public static int numAleatorioInter1000() {
        Random rnd = new Random();
        return rnd.nextInt(2001) - 1000;
    }

}
