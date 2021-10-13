package capitulo03.bloque03;

import java.util.Scanner;

public class Ejercicio07_PositNegat {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int valor;
        int neg = 0;
        int pos = 0;

        do {
            System.out.println("Introduce un numero: ");
            valor = sc.nextInt();
            if (valor != 0) {
                if (valor < 0) neg++;
                else pos++;
            }
        } while (valor != 0);

        System.out.println("Se han introducido " + neg + " numeros negativos y " + pos + " numeros positivos");
    }
}
