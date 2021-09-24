package capitulo01.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio02_ModifEjerAnterior {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		int num = Integer.parseInt(str);
		
		System.out.println("Numero introducido: " + num);
		
		str = JOptionPane.showInputDialog("Introduzca un número decimal: ");
		float num2 = Float.parseFloat(str);
		
		System.out.println("Numero introducido: " + num2);
		
		str = JOptionPane.showInputDialog("Introduzca un número real: ");
		double num3 = Double.parseDouble(str);
		
		System.out.println("Numero introducido: " + num3);
	}

}
