package capitulo04.bloque03;

public class Persona {
    private String nombre, apellido, direccion;
    private int dni, telefono;

    public Persona(){
        nombre = null;
        apellido = null;
        direccion = null;
        dni = 00000000;
        telefono = 000000000;
    }

    public Persona(String nombre, String apellido, String direccion, int dni, int telefono){
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDNI() {
        return dni;
    }

    public void setDNI(int DNI) {
        this.dni = DNI;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String toString(){
        return ("Nombre: " + this.nombre + " " + this.apellido + "\n" +
                "Direccion: " + this.direccion + "\n" +
                "DNI: " + this.dni + "\n" +
                "Telefono: " + this.telefono);
    }
}
