package capitulo01.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio04_MediaTresNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] numeros = new int[3];
		float media = 0;
		
		for(int i = 0; i<3; i++) {
			String str = JOptionPane.showInputDialog("Introduzca un número entero: ");
			numeros[i] = Integer.parseInt(str);
		}
		for(int i = 0; i<3; i++) {
			media += numeros[i];
		}
		
		System.out.println("La media de los tres numeros es: " + media/numeros.length);


	}

}
