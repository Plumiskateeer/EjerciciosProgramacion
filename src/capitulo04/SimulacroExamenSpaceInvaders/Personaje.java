package capitulo04.SimulacroExamenSpaceInvaders;

public class Personaje {
    private int puntosVida;
    private String nombre;
    private boolean vivo;

    public Personaje() {
    }

    public Personaje(int puntosVida, String nombre, boolean vivo) {
        this.puntosVida = puntosVida;
        this.nombre = nombre;
        this.vivo = vivo;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    @Override
    public String toString() {
        return "puntosVida=" + puntosVida +
               ", nombre='" + nombre + '\'' +
               ", vivo=" + vivo +
               '}';
    }
}
