package EjerciciosExtra;

public class Ejercicio01_ParesAdelante {
    public static void main(String[] args){
        int []  numeros = new int[20];

        for (int i = 0; i < numeros.length; i++) {

            numeros[i] = (int)(Math.round(Math.random()*100)); // numeros.length

        }
    }
}
