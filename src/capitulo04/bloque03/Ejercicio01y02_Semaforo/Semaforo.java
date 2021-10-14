package capitulo04.bloque03.Ejercicio01y02_Semaforo;

public class Semaforo {
    private String estado;
    private String peatones;

    /**
     * metodo default Semaforo
     */
    public Semaforo() {
        estado = "ROJO";
    }

    /**
     *
     * @return estado semaforo
     */
    public String getEstado() {
        return estado;
    }

    /**
     *
     * @param estado asigna valor al semaforo
     */
    public void setEstado(String estado) {
        if (estado.equals("VERDE")) setPeatones("ROJO");
        this.estado = estado;
    }

    /**
     *
     * @return estado semaforo de peatones
     */
    public String getPeatones() {
        return peatones;
    }

    /**
     *
     * @param peatones asignar valor semaforo de peatones
     */
    public void setPeatones(String peatones) {
        this.peatones = peatones;
    }
}

