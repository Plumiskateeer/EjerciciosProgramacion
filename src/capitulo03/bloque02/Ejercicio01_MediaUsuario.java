package capitulo03.bloque02;

import java.util.Scanner;

public class Ejercicio01_MediaUsuario {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        float suma = 0;

        System.out.println("¿Cuantos numeros vas a introducir?");
        int rep = sc.nextInt();

        for(int i = 0; i<rep; i++) {
            System.out.println("Introduce un numero: ");
            suma += sc.nextInt();
        }

        System.out.println("El resultado de la media es: " + suma/rep);
    }
}
