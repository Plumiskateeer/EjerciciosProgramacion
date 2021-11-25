package capitulo04.bloque0.Poker;

public class Carta {
    private String paloCarta;
    private int valorCarta, idCarta;

    public Carta() {
    }

    public Carta(String paloCarta, int valorCarta, int idCarta) {
        this.paloCarta = paloCarta;
        this.valorCarta = valorCarta;
        this.idCarta = idCarta;
    }

    public String getPaloCarta() {
        return paloCarta;
    }

    public void setPaloCarta(String paloCarta) {
        this.paloCarta = paloCarta;
    }

    public int getValorCarta() {
        return valorCarta;
    }

    public void setValorCarta(int valorCarta) {
        this.valorCarta = valorCarta;
    }

    public int getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(int idCarta) {
        this.idCarta = idCarta;
    }

    @Override
    public String toString() {
        return "Carta{" +
               "paloCarta='" + paloCarta + '\'' +
               ", valorCarta=" + valorCarta +
               ", idCarta=" + idCarta +
               '}';
    }
}
