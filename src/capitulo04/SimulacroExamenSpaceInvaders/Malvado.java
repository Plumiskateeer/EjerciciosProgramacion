package capitulo04.SimulacroExamenSpaceInvaders;

import java.awt.*;

public class Malvado extends Personaje{
    public Malvado() {
    }

    public Malvado(int puntosVida, String nombre, boolean vivo) {
        super(puntosVida, nombre, vivo);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(this.x,this.y,this.alto,this.ancho);
    }

    @Override
    public String toString() {
        return "M: " + super.toString();
    }
}
