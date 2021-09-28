package capitulo02.bloque01;

import java.util.Scanner;

public class Ejercicio07_ParImpar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero: ");
		int n = sc.nextInt();
		
		String str = Integer.toString(n);
		byte bits = Byte.valueOf(str);
		
		byte uno = 00000001;
		
		if((bits & uno) != uno) System.out.println("El numero es par");
		else System.out.println("El numero es impar");
		
	}

}
