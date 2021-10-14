package capitulo04.bloque03.Ejercicio03y04y05_PersonaBanco;

public class Cuenta {
    private Persona titular;
    private int dinero;

    /**
     * Constructor default cuenta
     */
    public Cuenta() {
        this.titular = new Persona(null,null,null,0,0);
        this.dinero = 0;
    }

    /**
     * Constructor general cuenta, datos de persona titular y dinero
     * @param dni dni de persona
     * @param nombre nombre titular
     * @param apellido apellido titular
     * @param direccion direccion titular
     * @param telefono numero de telefono
     * @param dinero dinero en la cuenta
     */
    public Cuenta(int dni, String nombre, String apellido, String direccion, int telefono, int dinero) {
        this.titular = new Persona(nombre,apellido,direccion,dni, telefono);
        this.dinero = dinero;
    }

    /**
     *
     * @return nombre titular cuenta
     */
    public String getNombre() {
        return this.titular.getNombre();
    }

    /**
     *
     * @param nombre introducir nombre titular cuenta
     */
    public void setNombre(String nombre) {
        this.titular.setNombre(nombre);
    }

    /**
     *
     * @return apellido titular cuenta
     */
    public String getApellido() {
        return this.titular.getApellido();
    }

    /**
     *
     * @param apellido introducir titular cuenta
     */
    public void setApellido(String apellido) {
        this.titular.setApellido(apellido);
    }

    /**
     *
     * @return dni titular cuenta
     */
    public int getDni() {
        return this.titular.getDNI();
    }

    /**
     *
     * @param dni introducir dni cuenta
     */
    public void setDni(int dni) {
        this.titular.setDNI(dni);
    }

    /**
     *
     * @return dinero cuenta
     */
    public int getDinero() {
        return this.dinero;
    }

    /**
     *
     * @param dinero introducir dinero cuenta
     */
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    /**
     * Metodo que transfiere dinero de una cuenta a otra
     * @param dinero dinero a transferir
     * @param destinatario cuenta destinataria que recibe el dinero
     */
    public void transferirDinero(int dinero, Cuenta destinatario) {
        if ((this.getDinero() - dinero) > 0) {
            this.setDinero(getDinero() - dinero);
            destinatario.setDinero(destinatario.getDinero() + dinero);
            System.out.println("Transferencia de " + this.getNombre() + " a " + destinatario.getNombre() + ". " + dinero + "€");
        } else System.out.println("Error, saldo insuficiente");
    }

    /**
     *
     * @return Objeto cuenta toString
     */
    public String toString() {
        return ("Titular: " + this.getNombre() + " " + this.getApellido() + "\n" +
                "DNI: " + this.getDni() + "\n" +
                "Dinero: " + this.getDinero() + "\n" + "\n");
    }

}
