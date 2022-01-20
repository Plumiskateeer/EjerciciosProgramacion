package capitulo04.SimulacroExamenSpaceInvaders;

public class Humano extends Personaje{
    public Humano() {
    }

    public Humano(int puntosVida, String nombre, boolean vivo) {
        super(puntosVida, nombre, vivo);
    }

    @Override
    public String toString() {
        return "HUMANO " + super.toString();
    }
}
