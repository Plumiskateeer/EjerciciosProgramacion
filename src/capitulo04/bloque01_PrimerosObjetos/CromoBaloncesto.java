package capitulo04.bloque01_PrimerosObjetos;

public class CromoBaloncesto {
    private String nombrejugador;
    private int alturacm;
    private float pesokg, puntos;

    public CromoBaloncesto(){

    }

    public CromoBaloncesto(String nombrejugador, int alturacm, float pesokg, float puntos) {
        this.nombrejugador = nombrejugador;
        this.alturacm = alturacm;
        this.pesokg = pesokg;
        this.puntos = puntos;
    }

    public String getNombrejugador() {
        return nombrejugador;
    }

    public void setNombrejugador(String nombrejugador) {
        this.nombrejugador = nombrejugador;
    }

    public int getAlturacm() {
        return alturacm;
    }

    public void setAlturacm(int alturacm) {
        this.alturacm = alturacm;
    }

    public float getPesokg() {
        return pesokg;
    }

    public void setPesokg(float pesokg) {
        this.pesokg = pesokg;
    }

    public float getPuntos() {
        return puntos;
    }

    public void setPuntos(float puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "CromoBaloncesto{" +
               "nombrejugador='" + nombrejugador + '\'' +
               ", alturacm=" + alturacm +
               ", pesokg=" + pesokg +
               ", puntos=" + puntos +
               '}';
    }
}
