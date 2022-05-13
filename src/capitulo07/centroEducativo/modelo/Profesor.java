package capitulo07.centroEducativo.modelo;

public class Profesor {

	private int id;

	private String apellido1;

	private String apellido2;

	private String direccion;

	private String dni;

	private String email;

	private String nombre;

	private String telefono;
	
	private int sexo;
	
	private byte [] imagen;
	
	private String colorpreferido;

	public Profesor() {
	}
	
	public Profesor(int i,String nombre, String apellido1, String apellido2, String direccion, 
			String dni, String email, String telefono, int sexo, byte[] imagen, String colorpreferido) {
		super();
		this.id = i;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.direccion = direccion;
		this.sexo = sexo;
		this.dni = dni;
		this.email = email;
		this.telefono = telefono;
		this.imagen = imagen;
		this.colorpreferido = colorpreferido;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getColorpreferido() {
		return colorpreferido;
	}

	public void setColorpreferido(String colorpreferido) {
		this.colorpreferido = colorpreferido;
	}
	
	



}