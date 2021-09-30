package capitulo03.bloque03;

import java.util.Scanner;

public class Ejercicio06_TablarMultiplicar {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        System.out.println("TABLAS DE MULTIPLICAR");

        int n;
        do {
            System.out.println("Introduce un numero: ");

            n = sc.nextInt();
            if(n!=0) {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(n * i + " = " + n + " * " + i);
                }
            }

        }while(n!=0);
    }
}
