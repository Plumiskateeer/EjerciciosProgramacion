package capitulo04.bloque03.banco;

public class Cuenta {
    private Persona titular;
    private int dinero;

    public Cuenta(){
        this.titular.setDNI(0);
        this.titular.setNombre(null);
        this.titular.setApellido(null);
        this.dinero = 0;
    }

    public Cuenta(int dni, String nombre, String apellido, int dinero){
        this.titular.setDNI(dni);
        this.titular.setNombre(nombre);
        this.titular.setApellido(apellido);
        this.dinero = dinero;
    }

    public void setNombre(String nombre){
        this.titular.setNombre(nombre);
    }
    public String getNombre(){
        return this.titular.getNombre();
    }
    public void setApellido(String apellido){
        this.titular.setApellido(apellido);
    }
    public String getApellido(){
        return this.titular.getApellido();
    }
    public void setDni(int dni){
        this.titular.setDNI(dni);
    }
    public int getDni(){
        return this.titular.getDNI();
    }
    public void setDinero(int dinero){
        this.dinero = dinero;
    }
    public int getDinero(){
        return this.dinero;
    }

    public void transferirDinero(int dinero, Cuenta destinatario){
        if((this.getDinero()-dinero) > 0) {
            this.setDinero(getDinero() - dinero);
            destinatario.setDinero(destinatario.getDinero() + dinero);
            System.out.println("Transferencia de " + this.getNombre() + " a " + destinatario.getNombre() + ". " + dinero + "€");
        }else System.out.println("Error, saldo insuficiente");
    }

    public String toString(){
        return ("Titular: " + this.getNombre() + " " + this.getApellido() + "\n" +
                "DNI: " + this.getDni() + "\n" +
                "Dinero: " + this.getDinero() + "\n" + "\n");
    }

}
