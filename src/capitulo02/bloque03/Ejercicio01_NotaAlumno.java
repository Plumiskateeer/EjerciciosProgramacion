package capitulo02.bloque03;

import java.util.Scanner;

public class Ejercicio01_NotaAlumno {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la nota obtenida: ");
        int nota = sc.nextInt();

        switch (nota) {
            case 1, 2 -> System.out.println("Muy deficiente");
            case 3, 4 -> System.out.println("Insuficiente");
            case 5 -> System.out.println("Suficiente");
            case 6 -> System.out.println("Bien");
            case 7, 8 -> System.out.println("Notable");
            case 9, 10 -> System.out.println("Sobresaliente");
            default -> throw new IllegalArgumentException("Unexpected value: " + nota);
        }
    }
}
