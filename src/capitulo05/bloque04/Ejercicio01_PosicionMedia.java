package capitulo05.bloque04;

public class Ejercicio01_PosicionMedia {
    public static void main(String[] args){

        int[] matriz = new int[(int)(Math.round(Math.random()*(20)))];

        // inicializo e imprimo
        System.out.println("Matriz original: ");
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = (int) (Math.round(Math.random() * (1000)));
            System.out.print(matriz[i] + " ");
        }

        // compruebo el tamaño y dependiendo de si es par o no igualo a su valor intermedio
        int valorPosMedia;
        if(matriz.length % 2 == 0) {
            valorPosMedia = -1;
        }else{
            valorPosMedia = matriz[(matriz.length-1)/2];
        }
        System.out.println("\nEl valor que se encuentra en la posicion intermedia es: " + valorPosMedia);

    }
}
