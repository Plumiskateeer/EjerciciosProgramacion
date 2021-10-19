package capitulo05.bloque01;

import java.util.Random;

public class Ejercicio05_SumaParesImpares {
    public static void main(String[]args){
        int [] matriz = new int[150];

        Random rnd = new Random();

        int sumPares = 0;
        int sumImpares = 0;

        for(int i = 0; i < matriz.length; i++){
            matriz[i] = rnd.nextInt(100) + 1;
            if(matriz[i]%2==0) sumPares++;
                else sumImpares++;
        }
        System.out.println("Hay " + sumPares + " numeros pares y " + sumImpares + " numeros impares");
    }
}
