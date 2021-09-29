package capitulo03.bloque02;

import java.util.Scanner;

public class Ejercicio04_MultiplosUser {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        boolean heLlegado = false;

        System.out.println("Introduce un numero para calcular sus multiplos: ");
        int n = sc.nextInt();
        System.out.println("Introduce el limite hasta el que llegar: ");
        int lim = sc.nextInt();
        System.out.println("Los multiplos son: ");

        int i = 1;
        while(!heLlegado) {
            if(n*i < lim)
                System.out.print(n * i + "  ");
            else heLlegado = true;
            i++;
        }
    }
}
