package capitulo04.bloque03.Ejercicio03y04y05_PersonaBanco;

public class Persona {
    private String nombre, apellido, direccion;
    private int dni, telefono;

    /**
     * Constructor default
     */
    public Persona() {
        nombre = null;
        apellido = null;
        direccion = null;
        dni = 0;
        telefono = 0;
    }

    /**
     * Constructor general persona
     * @param nombre nombre persona
     * @param apellido  apellido persona
     * @param direccion direccion persona
     * @param dni dni persona
     * @param telefono telefono persona
     */
    public Persona(String nombre, String apellido, String direccion, int dni, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
    }

    /**
     *
     * @return nombre persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre introducir nombre persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return apellido persona
     */
    public String getApellido() {
        return apellido;
    }

    /**
     *
     * @param apellido introducir apellido persona
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     *
     * @return direccion persona
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion introducir direccion persona
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return dni persona
     */
    public int getDNI() {
        return dni;
    }

    /**
     *
     * @param DNI introducir dni persona
     */
    public void setDNI(int DNI) {
        this.dni = DNI;
    }

    /**
     *
     * @return telefono persona
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     *
     * @param telefono introducir telefono persona
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @return imprimir datos persona
     */
    public String toString() {
        return ("Nombre: " + this.nombre + " " + this.apellido + "\n" +
                "Direccion: " + this.direccion + "\n" +
                "DNI: " + this.dni + "\n" +
                "Telefono: " + this.telefono);
    }
}
