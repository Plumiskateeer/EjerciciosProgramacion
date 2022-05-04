package capitulo07.centroEducativo.modelo;

public class TipologiaSexo {
	private int id;
	private String descripcion;
	
	public TipologiaSexo(){
		
	}
	
	public TipologiaSexo(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String toString() {
		return this.descripcion;
	}

}
