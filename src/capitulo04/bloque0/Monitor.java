package capitulo04.bloque0;

public class Monitor {
    private int pulgadas, brillo;
    private String relacionAspecto, conectores;
    private float contraste;

    public Monitor() {
    }

    public Monitor(int pulgadas, int brillo, String relacionAspecto, String conectores, float contraste) {
        this.pulgadas = pulgadas;
        this.brillo = brillo;
        this.relacionAspecto = relacionAspecto;
        this.conectores = conectores;
        this.contraste = contraste;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    public int getBrillo() {
        return brillo;
    }

    public void setBrillo(int brillo) {
        this.brillo = brillo;
    }

    public String getRelacionAspecto() {
        return relacionAspecto;
    }

    public void setRelacionAspecto(String relacionAspecto) {
        this.relacionAspecto = relacionAspecto;
    }

    public String getConectores() {
        return conectores;
    }

    public void setConectores(String conectores) {
        this.conectores = conectores;
    }

    public float getContraste() {
        return contraste;
    }

    public void setContraste(float contraste) {
        this.contraste = contraste;
    }

    @Override
    public String toString() {
        return "Monitor{" +
               "pulgadas=" + pulgadas +
               ", brillo=" + brillo +
               ", relacionAspecto='" + relacionAspecto + '\'' +
               ", conectores='" + conectores + '\'' +
               ", contraste=" + contraste +
               '}';
    }
}
