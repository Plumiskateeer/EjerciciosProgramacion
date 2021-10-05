package capitulo04.bloque03;

public class Semaforo {
    private String estado;
    private String peatones;

    public Semaforo(){
        estado = "ROJO";
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if(estado.equals("VERDE")) setPeatones("ROJO");
        this.estado = estado;
    }

    public String getPeatones(){
        return peatones;
    }

    public void setPeatones(String peatones){
        this.peatones = peatones;
    }
}

