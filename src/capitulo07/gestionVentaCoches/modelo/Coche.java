package capitulo07.gestionVentaCoches.modelo;

public class Coche {
    private int id, idfabricante;
    private String bastidor, modelo, color;

    public Coche(int id, int idfabricante, String bastidor, String modelo, String color) {
        this.id = id;
        this.idfabricante = idfabricante;
        this.bastidor = bastidor;
        this.modelo = modelo;
        this.color = color;
    }

    public Coche() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdfabricante() {
        return idfabricante;
    }

    public void setIdfabricante(int idfabricante) {
        this.idfabricante = idfabricante;
    }

    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return modelo + " " + color;
    }
}
