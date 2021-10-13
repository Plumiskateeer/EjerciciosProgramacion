package capitulo02.bloque01;

import java.util.Scanner;

public class Ejercicio06_ParImpar {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un numero: ");
        int num = sc.nextInt();

        if(num%2==0) System.out.println("El numero es par");
            else System.out.println("El numero es impar");
    }
}
