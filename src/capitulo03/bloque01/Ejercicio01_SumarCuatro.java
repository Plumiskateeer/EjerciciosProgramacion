package capitulo03.bloque01;

import java.util.Scanner;

public class Ejercicio01_SumarCuatro {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        int suma = 0;
        int valor;

        for(int i = 0; i<4; i++) {
            System.out.println("Introduce un numero: ");
            valor = sc.nextInt();
            if(valor > 10) suma+=valor;
        }

        System.out.println("El resultado de sumar los numeros mayores de 10 es: " + suma);
    }
}
