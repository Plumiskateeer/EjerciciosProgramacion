package capitulo04.bloque0.batalla;

public class Personaje {
    private int puntosVida, puntosFuerza;
    private float porcentajeAcierto;

    public Personaje(){
        this.puntosFuerza = (int) Math.round(Math.random() * 100);
        this.puntosVida = (int) Math.round(Math.random() * 50) + 50;
        this.porcentajeAcierto = (float) Math.round(Math.random() * 60);
    }
    public Personaje(int puntosVida, int puntosFuerza, float porcentajeAcierto) {
        this.puntosVida = puntosVida;
        this.puntosFuerza = puntosFuerza;
        this.porcentajeAcierto = porcentajeAcierto;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getPuntosFuerza() {
        return puntosFuerza;
    }

    public void setPuntosFuerza(int puntosFuerza) {
        this.puntosFuerza = puntosFuerza;
    }

    public float getPorcentajeAcierto() {
        return porcentajeAcierto;
    }

    public void setPorcentajeAcierto(float porcentajeAcierto) {
        this.porcentajeAcierto = porcentajeAcierto;
    }

    public String toString() {
        return "HP:" + this.puntosVida;
    }
}
