package capitulo03.bloque01;

import java.util.Scanner;

public class Ejercicio03_ModifPosNegAnterior {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        int suma = 0;
        int valor;
        int neg = 0;
        int pos = 0;

        System.out.println("¿Cuantos numeros vas a sumar?");
        int rep = sc.nextInt();

        for(int i = 0; i<rep; i++) {
            System.out.println("Introduce un numero: ");
            valor = sc.nextInt();
            if(valor > 10) suma+=valor;
            if(valor < 0)  neg++;
                else pos++;
        }

        System.out.println("El resultado de sumar los numeros mayores de 10 es: " + suma);
        System.out.println("Se han introducido " + neg + " numeros negativos y " + pos + " numeros positivos");
    }
}
