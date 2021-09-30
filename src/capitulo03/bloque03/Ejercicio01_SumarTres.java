package capitulo03.bloque03;

import java.util.Scanner;

public class Ejercicio01_SumarTres {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        int n = 1;
        int suma = 0;
        while(n!=0){
            System.out.println("Introduce un numero: ");
            n = sc.nextInt();
            suma+=n;
        }

        System.out.println("La suma de los numeros es: " + suma);
    }
}
