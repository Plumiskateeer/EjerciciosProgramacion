package capitulo01.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio03_SumadeTresNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		int suma = 0;
		
		
			String str = JOptionPane.showInputDialog("Introduzca un número entero: ");
			n1 = Integer.parseInt(str);
			
			str = JOptionPane.showInputDialog("Introduzca un número entero: ");
			n2 = Integer.parseInt(str);
			
			str = JOptionPane.showInputDialog("Introduzca un número entero: ");
			n3 = Integer.parseInt(str);
			
		
		suma = n1 + n2 + n3;
		
		System.out.println("La suma de los tres numeros es: " + suma);

	}

}
