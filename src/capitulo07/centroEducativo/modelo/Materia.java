package capitulo07.centroEducativo.modelo;

public class Materia {

	private int id;

	private String acronimo;

	private String nombre;
	
	private int cursoid;



	public Materia(int id, String acronimo, String nombre, int cursoid) {
		super();
		this.id = id;
		this.acronimo = acronimo;
		this.nombre = nombre;
		this.cursoid = cursoid;
	}

	public Materia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAcronimo() {
		return this.acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCursoid() {
		return cursoid;
	}

	public void setCursoid(int cursoid) {
		this.cursoid = cursoid;
	}
	

}