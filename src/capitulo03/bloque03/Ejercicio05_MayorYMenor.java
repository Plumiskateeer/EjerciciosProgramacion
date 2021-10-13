package capitulo03.bloque03;

import java.util.Scanner;

public class Ejercicio05_MayorYMenor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 1;
        int mayor = 0;
        int menor = 1000;
        while (n != 0) {
            System.out.println("Introduce un numero: ");
            n = sc.nextInt();
            if (n > mayor) mayor = n;
            if (n < menor) menor = n;
        }

        System.out.println("El mayor numero es: " + mayor);
        System.out.println("El menor numero es: " + menor);
    }
}
