package capitulo01.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio05_IntercambioNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		int num = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		int num2 = Integer.parseInt(str);
		
		System.out.println("Numeros ANTES: " + num + " " + num2);
		
		int aux = num;
		num = num2;
		num2 = aux;
		
		System.out.println("Numeros DESPUES: " + num + " " + num2);

	}

}
