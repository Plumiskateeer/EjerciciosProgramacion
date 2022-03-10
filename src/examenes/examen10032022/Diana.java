package examenes.examen10032022;

import java.util.ArrayList;
import java.util.List;

public class Diana {
    private List<Jugada> jugadas = new ArrayList<>();
    private int[] numeros = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,50,100};


    public Diana(){
        for(int i=0; i<numeros.length; i++){
            jugadas.add(new Jugada(i + 1,numeros[i]));
        }
    }

    public List<Jugada> getJugadas() {
        return jugadas;
    }

    public void setJugadas(List<Jugada> jugadas) {
        this.jugadas = jugadas;
    }

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Jugada j : jugadas){
            sb.append("\n").append("Jugada n ").append(j.getId()).append(": ").append(j.getNumero());
        }
        return sb.toString();
    }
}
