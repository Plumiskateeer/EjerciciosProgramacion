package capitulo02.bloque02;

import java.util.Scanner;

public class Ejercicio01_SumarCinco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int [] numeros = new int[5]; 
		
		for(int i = 0; i<5; i++) {
		System.out.println("Introduce un numero");
		numeros[i] = sc.nextInt();
		}
		
		int neg = 0;
		int baj = 0;
		int med = 0;
		int gra = 0;
		
		for(int i = 0; i<5; i++) {
			if(numeros[i]<0) neg+=numeros[i];
			else if(numeros[i]<26) baj+=numeros[i]; // grande +=var;
			else if(numeros[i]<251) med+=numeros[i];
			else gra+=numeros[i];
		}
		
		System.out.println("Suma numeros negativos: " + neg);
		System.out.println("Suma numeros bajos: " + baj);
		System.out.println("Suma numeros medios: " + med);
		System.out.println("Suma numeros grandes: " + gra);

	}

}
