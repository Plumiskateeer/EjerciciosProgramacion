package capitulo07.centroEducativo.modelo;


public class Curso {

	private int id;

	private String descripcion;

	public Curso() {
	}
	public Curso(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String toString() {
		return this.descripcion;
	}
}