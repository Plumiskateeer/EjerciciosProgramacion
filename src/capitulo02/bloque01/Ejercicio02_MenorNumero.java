package capitulo02.bloque01;

import java.util.Scanner;

public class Ejercicio02_MenorNumero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Introduce un numero: ");
        int n1 = sc.nextInt();
        System.out.println("Introduce otro numero: ");
        int n2 = sc.nextInt();

        if (n1 <= n2) System.out.println("El numero menor es " + n1);
        else System.out.println("El numero menor es " + n2);

    }

}
