package capitulo02.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio03_MayordeCincoNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] numeros = new int[5];
		 
		for(int i = 0; i<numeros.length; i++) {
			String str = JOptionPane.showInputDialog("Introduzca un número entero: ");
			numeros[i] = Integer.parseInt(str);
		}
		
		int mayor = 0;
		for(int i = 0; i<numeros.length; i++) {
			if(numeros[i]>mayor) mayor = numeros[i];
		}
		
		System.out.println("El numero mayor es: " + mayor);

	}

}
