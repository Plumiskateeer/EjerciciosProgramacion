package capitulo02.bloque03;

import java.util.Scanner;

public class Ejercicio02_Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("BIENVENIDO A LA CALCULADORA");
            System.out.println(".--------------------.");
            System.out.println("1 para modulo division");
            System.out.println("2 para calcular la raiz cuadrada");
            System.out.println("3 para la potencia");
            System.out.println(".--------------------.");
            System.out.println("Elige la operacion a realizar, 0 para salir: ");
            op = sc.nextInt();


            switch (op) {
                case 1 -> System.out.println("El modulo de la division es " + modDiv());
                case 2 -> System.out.println("El resultado de la raiz es: " + raiz());
                case 3 -> System.out.println("El resultado de la potencia es: " + potencia());
            }
        } while (op != 0);
    }

    public static int modDiv() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el dividendo: ");
        int dividendo = sc.nextInt();
        System.out.println("Introduce el divisor: ");
        int divisor = sc.nextInt();

        return dividendo % divisor;
    }

    public static double raiz() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el numero al que calcular la raiz: ");
        double n = sc.nextDouble();

        return Math.sqrt(n);

    }

    public static double potencia() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la base de la potencia: ");
        int b = sc.nextInt();
        System.out.println("Introduce el exponente de la potencia: ");
        int ex = sc.nextInt();

        return Math.pow(b, ex);
    }
}













