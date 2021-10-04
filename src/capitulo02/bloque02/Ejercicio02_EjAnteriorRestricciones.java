package capitulo02.bloque02;

import java.util.Scanner;

public class Ejercicio02_EjAnteriorRestricciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int [] numeros = new int[5];
		
		boolean hayNegativo = false;
		
		for(int i = 0; i<numeros.length && !hayNegativo; i++) {
			System.out.println("Introduce un numero");
			int v = sc.nextInt();
				if(v > 0)
					numeros[i] = v;
				else hayNegativo = true;
		}
		if(!hayNegativo) {
		int baj = 0;
		int med = 0;
		int gra = 0; 
		
		for(int i = 0; i<5; i++) {
			if(numeros[i]<26) baj+=numeros[i];
				else if(numeros[i]<251) med+=numeros[i];
					else gra+=numeros[i];
		}
		System.out.println("Suma numeros bajos: " + baj);
		System.out.println("Suma numeros medios: " + med);
		System.out.println("Suma numeros grandes: " + gra);
		}else{
			System.out.println("Error, numero negativo");
		}
	}

}
