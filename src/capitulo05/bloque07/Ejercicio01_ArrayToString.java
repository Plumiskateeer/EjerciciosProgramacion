package capitulo05.bloque07;

public class Ejercicio01_ArrayToString {
    public static void main(String[] args){
        int[]  matriz = new int[10];
        inicializarMatriz(matriz);
        System.out.println(arrayToString(matriz));
    }

    public static void inicializarMatriz(int[] matriz){
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = (int)(Math.round(Math.random()*10));
        }
    }
    public static String arrayToString(int[] matriz){
        StringBuilder sb = new StringBuilder();
        sb.append("La matriz es: ");
        for(int i : matriz){
            sb.append(i);
            sb.append(" ");
        }
        return sb.toString();
    }

}
