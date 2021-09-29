package capitulo02.bloque03;

import java.util.Scanner;

public class Ejercicio03_CalculadoraGeometrica {
    public static void main(String[]args){
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

            if(op>-1 && op<6) {

                switch (op) {
                    case 1: {
                        System.out.println("La hipotenusa es " + hipTriangulo());
                        break;
                    }
                    case 2: {
                        System.out.println("La superficie de la cincurferencia es: " + supCircunferencia());
                        break;
                    }
                    case 3: {
                        System.out.println("El perimetro de la circunferencia es: " + perimCircunferencia());
                        break;
                    }
                    case 4: {
                        System.out.println("El area del rectangulo es: " + areaRect());
                        break;
                    }
                    case 5: {
                        System.out.println("El area del triangulo es: " + areaTriang());
                        break;
                    }

                }
            }else{
                System.out.println("\nOpcion incorrecta\n");
            }
        }while(op!=0);
    }

    public static double hipTriangulo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el cateto a: ");
        int a = sc.nextInt();
        System.out.println("Introduce el cateto b: ");
        int b = sc.nextInt();

        return Math.pow(a,2) + Math.pow(b,2);
    }
    public static double supCircunferencia(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el radio de la circunferencia: ");
        double r = sc.nextDouble();

        return Math.pow(r,2) * Math.PI;

    }
    public static double perimCircunferencia(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el radio de la circunferencia: ");
        int r = sc.nextInt();

        return 2*Math.PI*r;
    }
    public static int areaRect(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la base del rectangulo: ");
        int b = sc.nextInt();
        System.out.println("Introduce la altura del rectangulo: ");
        int h = sc.nextInt();

        return b*h;
    }
    public static int areaTriang(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la base del triangulo: ");
        int b = sc.nextInt();
        System.out.println("Introduce la altura del triangulo: ");
        int h = sc.nextInt();

        return (b*h)/2;
    }
}
/*
 a.- Que muestre un menú en pantalla con opciones para:
                           1. Cálculo de la hipotenusa de un triángulo.
                           2. Cálculo de la superficie de una circunferencia.
                           3. Cálculo del perímetro de una circunferencia.
                           4. Cálculo del área de un rectángulo.
                           5. Cálculo del área de un triángulo.
                           0. Salir de la aplicación.
 b.- En la opción "1" debe pedir dos datos, correspondientes a las longitudes de los dos catetos de un triángulo.
  Se debe imprimir la longitud de la hipotenusa. Recuerda que Hipotenusa al cuadrado = cateto1 al cuadrado + cateto2 al cuadrado.
 c.- En la opción "2" debe pedir la longitud del radio de una circunferencia e imprimir la superficie de la misma.
  Recuerda que el área es igual a PI por el radio al cuadrado. Recuerda también que PI es igual a 3,1416.
 d.- En la opción "3" debe pedir la longitud del radio de una circunferencia e imprimir la longitud del perímetro de la misma.
 Recuerda que la longitud de la circunferencia = 2 por PI por el radio.
 e.- En la opción "4" debe pedir las longitudes de la base y la altura de un rectángulo, e imprimir el área de dicho rectángulo.
 Recuerda que el área del rectángulo es igual a la base por la altura.
 f.- En la opción "5" debe pedir la base y la altura de un tríangulo e imprimir el área del mismo.
 Recuerda que el área del triángulo es la mitad del área del rectángulo de igual base y altura.
 g.- Tras mostrar el resultado de cada opción, el programa debe hacer una pausa (para poder observar el resultado), y volver a pintar el menú.
 Esto se repetirá siempre que la opción no sea "0", en cuyo caso el programa acabará.
 h.- Si la opción no fuese "0", "1", "2", "3", "4" o "5", el programa deberá dar el mensaje de "opción incorrecta" y volverá a mostrar el menú.
 */
