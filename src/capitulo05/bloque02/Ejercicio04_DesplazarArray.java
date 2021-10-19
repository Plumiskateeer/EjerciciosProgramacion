package capitulo05.bloque02;

public class Ejercicio04_DesplazarArray {
    public static void main(String[] args){
        int [] matriz = new int[5];

        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = (int) (Math.round(Math.random()*(100)));
        }
        int ultimo = matriz[matriz.length-1];
        int aux = matriz[1];
        int aux2;
        for (int i = 0; i < matriz.length ; i++) {
            aux = matriz[i+1];
            matriz[i+1] = matriz[i];
            aux2 = matriz[i+2];
            matriz[i+2] = aux;
            aux
        }
    }
}
