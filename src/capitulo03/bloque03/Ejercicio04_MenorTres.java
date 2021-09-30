package capitulo03.bloque03;

import java.util.Scanner;

public class Ejercicio04_MenorTres {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        int n = 1;
        int menor = 1000;
        while(n!=0){
            System.out.println("Introduce un numero: ");
            n = sc.nextInt();
            if(n < menor) menor = n;
        }

        System.out.println("El menor numero es: " + menor);
    }
}
