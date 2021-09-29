package capitulo02.bloque03;

import java.util.Scanner;

public class Ejercicio01_NotaAlumno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce la nota obtenida: ");
		int nota = sc.nextInt();

		switch (nota) {
		case 1: case 2: {
			System.out.println("Muy deficiente");
			break;
		}
		case 3: case 4: {
			System.out.println("Insuficiente");
			break;
		}
		case 5: {
			System.out.println("Suficiente");
			break;
		}
		case 6: {
			System.out.println("Bien");
			break;
		}
		case 7: case 8:  {
			System.out.println("Notable");
			break;
		}
		case 9: case 10:{
			System.out.println("Sobresaliente");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + nota);
		}
	}
}
