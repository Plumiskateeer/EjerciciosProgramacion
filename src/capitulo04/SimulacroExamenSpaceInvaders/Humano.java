package capitulo04.SimulacroExamenSpaceInvaders;

import java.awt.*;

public class Humano extends Personaje{
    public Humano() {
    }

    public Humano(int puntosVida, String nombre, boolean vivo) {
        super(puntosVida, nombre, vivo);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(this.x,this.y,this.alto,this.ancho);
    }

    @Override
    public String toString() {
        return "H: " + super.toString();
    }
}
