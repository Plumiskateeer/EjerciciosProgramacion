package capitulo03.bloque03;

import java.util.Scanner;

public class Ejercicio02_MediaTres {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 1;
        float suma = 0;
        int cont = 0;
        while (n != 0) {
            System.out.println("Introduce un numero: ");
            n = sc.nextInt();
            if(n!=0) {
                suma += n;
                cont++;
            }
        }

        System.out.println("La media de los numeros es: " + suma / cont);
    }
}
