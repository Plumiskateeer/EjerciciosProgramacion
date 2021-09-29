package capitulo03.bloque02;

import java.util.Scanner;

public class Ejercicio02_MayorYMenor {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        int mayor = 0;
        int menor = 100;
        int valor;

        System.out.println("¿Cuantos numeros vas a introducir?");
        int rep = sc.nextInt();

        for(int i = 0; i<rep; i++) {
            System.out.println("Introduce un numero: ");
            valor = sc.nextInt();
            if(valor > mayor) mayor = valor;
            if(valor < menor) menor = valor;
        }

        System.out.println("El mayor numero introducido es:" + mayor);
        System.out.println("El menor numero introducido es:" + menor);
    }
}
