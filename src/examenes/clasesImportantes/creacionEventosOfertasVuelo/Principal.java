package examenes.clasesImportantes.creacionEventosOfertasVuelo;

public class Principal {

	public static void main(String[] args) {
		Persona rafa = new Persona();
		
		CentralViajes.addOfertaListener(rafa);
		
		Empresa albertoSA = new Empresa();
		
		CentralViajes.addOfertaListener(albertoSA);
		
		
		CentralViajes.fireNewOfertaEvent();
		
		
	}

}
