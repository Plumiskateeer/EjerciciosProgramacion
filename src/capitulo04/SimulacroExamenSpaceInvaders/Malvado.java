package capitulo04.SimulacroExamenSpaceInvaders;

public class Malvado extends Personaje{
    public Malvado() {
    }

    public Malvado(int puntosVida, String nombre, boolean vivo) {
        super(puntosVida, nombre, vivo);
    }


    @Override
    public String toString() {
        return "M: " + super.toString();
    }
}
