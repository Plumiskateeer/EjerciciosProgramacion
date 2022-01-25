package capitulo04.SimulacroExamenSpaceInvaders;

import java.awt.*;

public abstract class Personaje extends MiCanvas {
    private int puntosVida, tirosRecibidos;
    private String nombre;
    private boolean vivo;
    protected int x, y;
    protected int ancho = 30, alto = 30;
    protected String img;

    public Personaje() {
    }

    public Personaje(int puntosVida, String nombre, boolean vivo) {
        this.puntosVida = puntosVida;
        this.nombre = nombre;
        this.vivo = vivo;
        this.tirosRecibidos = 0;
    }

    @Override
    public abstract void paint(Graphics g);

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        if (puntosVida < 0) this.puntosVida = 0;
        else this.puntosVida = puntosVida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isVivo() {
        if (puntosVida > 0) vivo = true;
        else vivo = false;
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public void sumarDisparo(){
        this.tirosRecibidos++;
    }

    public int getTirosRecibidos(){
        return this.tirosRecibidos;
    }

    @Override
    public String toString() {
        String status = "";
        if (vivo) status = "O.o";
        else status = "X.x";
        return "PV:" + puntosVida +
               ", ID:" + nombre +
               ", STATUS:" + status ;
    }
}
