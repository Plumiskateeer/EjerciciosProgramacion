package capitulo03.bloque02;

import java.util.Scanner;

public class Ejercicio03_Multiplos100 {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        boolean heLlegado = false;

        System.out.println("Introduce un numero para calcular sus multiplos menores que 100");
        int n = sc.nextInt();
        System.out.println("Los multiplos son: ");

        int i = 1;
        while(!heLlegado) {
            if(n*i < 100)
                System.out.print(n * i + "  ");
            else heLlegado = true;
            i++;
        }
        }

}
