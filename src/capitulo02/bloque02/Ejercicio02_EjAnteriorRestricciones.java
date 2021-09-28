package capitulo02.bloque02;

import java.util.Scanner;

public class Ejercicio02_EjAnteriorRestricciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int [] numeros = new int[5]; 
		
		boolean hayCero = false;
		
		for(int i = 0; i<5 && !hayCero; i++) {
			System.out.println("Introduce un numero");
			int v = sc.nextInt();
				if(v != 0)
					numeros[i] = v;
				else hayCero = true;
		}
		if(!hayCero) {
		int neg = 0;
		int baj = 0;
		int med = 0;
		int gra = 0; 
		
		for(int i = 0; i<5; i++) {
			if(numeros[i]<0) neg+=numeros[i];
				else if(numeros[i]<26) baj+=numeros[i];
					else if(numeros[i]<251) med+=numeros[i];
						else gra+=numeros[i];
		}
		
		System.out.println("Suma numeros negativos: " + neg);
		System.out.println("Suma numeros bajos: " + baj);
		System.out.println("Suma numeros medios: " + med);
		System.out.println("Suma numeros grandes: " + gra);
		}
	}

}
