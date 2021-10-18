package capitulo01.bloque01;

import javax.swing.*;
import java.util.Random;

public class QuitardeArray {
    public static void main(String[]args){
        int [] matriz = new int[10];

        Random rnd = new Random();

        System.out.println("Matriz de num aleatorios original.");
        for(int i = 0; i < matriz.length; i++){
            matriz[i] = rnd.nextInt(10)+1;
            System.out.print(matriz[i] + " ");
        }

        int i = 1;

        int [] aux;

        while(i!=0){
            i = Integer.parseInt(JOptionPane.showInputDialog("Que numero quiere retirar del array? (0 para terminar)"));
            aux = eliminarDeMatriz(i,matriz); // pido que me devuelva esa matriz sin ese numero
            matriz = aux; // actualizo la matriz a esa ya editada para que no introduzca en el metodo siempre la misma inicial
            System.out.println("Matriz sin " + i);
            for (int j : aux) {
                System.out.print(j + " "); // imprimo por pantalla
            }
        }
    }
    public static int[] eliminarDeMatriz(int num, int [] matriz){

        for(int i = 0; i < matriz.length; i++){
            if(matriz[i]==num){ // si encuentro el numero
                int [] izq = new int[i]; // creo una matriz para los elem a la izquierda del numero
                // relleno esa matriz
                System.arraycopy(matriz, 0, izq, 0, izq.length);
                int [] der = new int[matriz.length-i-1];  // creo una matriz para los elem a la derecha del num
                for(int j = 0; j < der.length; j++){
                    der[j] = matriz[j+i+1];    // la relleno
                }
                int[] auxiliar = new int[izq.length+der.length];  // creo una matriz para juntar en ella izq y der
                System.arraycopy(izq, 0, auxiliar, 0, izq.length);  // copio la parte izq
                System.arraycopy(der, 0, auxiliar, izq.length, der.length); // copio la parte der
                matriz = new int[auxiliar.length]; // hago que la original tenga uno menos de longitud
                System.arraycopy(auxiliar, 0, matriz, 0, auxiliar.length);
                // copio la auxiliar en la original para que siga el bucle con la matriz editada
                i = 0; // reseteo el indice del for para que empiece de nuevo
            }
        }
        return matriz; // devuelvo la matriz para q la imprima el main
    }
}
