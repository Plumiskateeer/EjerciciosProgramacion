package capitulo06.excepciones.ejercicio01;

import javax.swing.JOptionPane;

public class PeticionNumeros {

	public static void main(String[] args) {

		int num = 0;

		do {
			num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero: "));

			try {
				pideNumeroPar(num);
			} catch (NumeroParException e) {
				e.printStackTrace();
			}

		} while (!(num % 2 == 0));
	}

	/**
	 * @param num
	 * @return
	 * @throws NumeroParException
	 */
	private static void pideNumeroPar(int num) throws NumeroParException {

		if (num % 2 == 0) {
			throw new NumeroParException("Numero par introducido");
		} else {
			System.out.println("Numero primo introducido");
		}

	}

}