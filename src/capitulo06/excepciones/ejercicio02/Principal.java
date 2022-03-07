package capitulo06.excepciones.ejercicio02;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		String str = JOptionPane.showInputDialog("Introduce una frase con la palabra 'bombilla':");
		System.out.println(str);
		
		try {
			comprobarFrase(str);
		} catch (SoloEspaciosException | PalabraOfensivaFoundException | MenorDe3PalabrasException | BombillaNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param str
	 * @throws SoloEspaciosException
	 * @throws MenorDe3PalabrasException
	 * @throws BombillaNotFoundException
	 * @throws PalabraOfensivaFoundException
	 */
	private static void comprobarFrase(String str) throws SoloEspaciosException, MenorDe3PalabrasException, BombillaNotFoundException, PalabraOfensivaFoundException {

		str=str.trim();
		String[] palabras = str.split(" ");

		//error1
		if(str.equals("")) throw new SoloEspaciosException("\nSe han introducido unicamente espacios en blanco");
		
		//error2
		if(palabras.length<3) throw new MenorDe3PalabrasException("\nSe han introducido menos de 3 palabras");
		
		//error3
		boolean bombilla = false;
		for (int i = 0; i < palabras.length; i++) {
			if(palabras[i].equals("bombilla")) {
				bombilla = true;
			}
		}
		if(!bombilla) throw new BombillaNotFoundException("\nLa palabra bombilla no esta");
		
		//error4
		for (int i = 0; i < palabras.length; i++) {
			if(palabras[i].equals("tonto")|palabras[i].equals("tonta")|palabras[i].equals("idiota")) {
				throw new PalabraOfensivaFoundException("\nLa frase contiene una palabra ofensiva");
			}
		}	
	}

}
