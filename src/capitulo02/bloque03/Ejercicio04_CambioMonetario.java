package capitulo02.bloque03;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio04_CambioMonetario {
    public static void main(String[] args) {

        //generamos un numero aleatorio que nos servira para dictar un precio
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int[] billetes = {100, 50, 25, 5, 1};
        int[] repbilletes = new int[5];
        int coste = rnd.nextInt(1000) + 1;

        //pedimos datos al usuario
        System.out.println("El articulo cuesta: " + coste);
        System.out.println("Introduce el dinero para pagarlo: ");
        int dinero = sc.nextInt();

        int cambio = dinero - coste; // aqui obtenemos la diferencia a devolver

        System.out.println("Para devolver " + cambio + " hemos necesitado: ");

        for (int i = 0; i < billetes.length; i++) {
            // si el modulo de esa division nos da 0 significa que esa cantidad contiene "x" billetes[i]
            repbilletes[i] = cambio / billetes[i]; // aqui almacenamos cuantos billetes necesitamos de ese tamaño
            cambio -= repbilletes[i] * billetes[i]; // aqui restamos la cantidad, ej 1625 - 1600 porque 100*16 = 1600
            System.out.println("Monedas de " + billetes[i] + ": " + repbilletes[i]);

        }
    }
}
