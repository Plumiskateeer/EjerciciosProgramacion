package capitulo02.bloque03;

import java.util.Scanner;

public class Ejercicio03_CalculadoraGeometrica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("BIENVENIDO A LA CALCULADORA GEOMETRICA");
            System.out.println(".-------------------------------------.");
            System.out.println(
                    "1. Cálculo de la hipotenusa de un triángulo.\n" +
                    "2. Cálculo de la superficie de una circunferencia.\n" +
                    "3. Cálculo del perímetro de una circunferencia.\n" +
                    "4. Cálculo del área de un rectángulo.\n" +
                    "5. Cálculo del área de un triángulo.\n" +
                    "0. Salir de la aplicación.");
            System.out.println(".-------------------------------------.");
            System.out.println("Elige la operacion a realizar, 0 para salir: ");
            op = sc.nextInt();

            if (op > -1 && op < 6) {

                switch (op) {
                    case 1 : System.out.println("La hipotenusa es " + hipTriangulo() + "\n");

                    case 2 : System.out.println("La superficie de la cincurferencia es: " + supCircunferencia() + "\n");

                    case 3 : System.out.println("El perimetro de la circunferencia es: " + perimCircunferencia() + "\n");

                    case 4 : System.out.println("El area del rectangulo es: " + areaRect() + "\n");

                    case 5 : System.out.println("El area del triangulo es: " + areaTriang() + "\n");
                }
            } else {
                System.out.println("\nOpcion incorrecta\n");
            }
        } while (op != 0);
    }
    /*
    Calculo de la hipotenusa del triangulo
     */
    public static double hipTriangulo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el cateto a: ");
        int a = sc.nextInt();
        System.out.println("Introduce el cateto b: ");
        int b = sc.nextInt();

        return Math.pow(a, 2) + Math.pow(b, 2);
    }
    /*
    Calculo de la superficie del circulo
     */
    public static double supCircunferencia() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el radio de la circunferencia: ");
        double r = sc.nextDouble();

        return Math.pow(r, 2) * Math.PI;

    }
    /*
    Calculo del perimetro de la circunferencia
     */
    public static double perimCircunferencia() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el radio de la circunferencia: ");
        int r = sc.nextInt();

        return 2 * Math.PI * r;
    }
    /*
    Calculo del area del rectangulo
     */
    public static int areaRect() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la base del rectangulo: ");
        int b = sc.nextInt();
        System.out.println("Introduce la altura del rectangulo: ");
        int h = sc.nextInt();

        return b * h;
    }
    /*
    Calculo del area del triangulo
     */
    public static int areaTriang() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la base del triangulo: ");
        int b = sc.nextInt();
        System.out.println("Introduce la altura del triangulo: ");
        int h = sc.nextInt();

        return (b * h) / 2;
    }
}

