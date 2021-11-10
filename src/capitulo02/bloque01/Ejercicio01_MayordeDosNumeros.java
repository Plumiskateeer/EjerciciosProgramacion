package capitulo02.bloque01;

import java.util.Scanner;

public class Ejercicio01_MayordeDosNumeros {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un numero: ");
        int n1 = sc.nextInt();
        System.out.println("Introduce otro numero: ");
        int n2 = sc.nextInt();

        System.out.println("El mayor es " + mayorde2(n1,n2));

    }

    public static int mayorde2(int n1, int n2) {
        return Math.max(n1, n2);
    }

}
