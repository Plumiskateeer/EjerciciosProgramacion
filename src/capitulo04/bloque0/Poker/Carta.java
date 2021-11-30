package capitulo04.bloque0.Poker;

public class Carta {
    private String palo;
    private int valor, id;

    public Carta() {
    }

    public Carta(String palo, int valor, int id) {
        this.palo = palo;
        this.valor = valor;
        this.id = id;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Carta{" +
               "paloCarta='" + palo + '\'' +
               ", valorCarta=" + valor +
               ", idCarta=" + id +
               '}';
    }
}
