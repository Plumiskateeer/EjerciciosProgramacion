package capitulo03.bloque03;

import java.util.Scanner;

public class Ejercicio03_MayorTres {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 1;
        int mayor = 0;
        while (n != 0) {
            System.out.println("Introduce un numero: ");
            n = sc.nextInt();
            if (n > mayor) mayor = n;
        }

        System.out.println("El mayor numero es: " + mayor);
    }
}
