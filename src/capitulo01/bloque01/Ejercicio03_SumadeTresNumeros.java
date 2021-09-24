package capitulo01.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio03_SumadeTresNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] numeros = new int[3];
		int suma = 0;
		
		for(int i = 0; i<3; i++) {
			String str = JOptionPane.showInputDialog("Introduzca un número entero: ");
			numeros[i] = Integer.parseInt(str);
		}
		for(int i = 0; i<3; i++) {
			suma += numeros[i];
		}
		
		System.out.println("La suma de los tres numeros es: " + suma);

	}

}
