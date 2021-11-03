package EjerciciosExtra;

public class Ejercicio01_ParesAdelante {
    public static void main(String[] args){
        int []  numeros = new int[20];
        int nPares = 0;
        int [] pares = new int[numeros.length];
        int nImpares = 0;
        int [] impares = new int[numeros.length];

        System.out.println("Matriz original");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.round(Math.random()*100));
            System.out.print(numeros[i] + " ");
            if(numeros[i]%2==0) {
                pares[nPares] = numeros[i];
                nPares++;
            }else{
                impares[nImpares] = numeros[i];
                nImpares++;
                }
        }

        System.arraycopy(pares, 0, numeros, 0, nPares);
        System.arraycopy(impares, 0, numeros, nPares, nImpares);

        System.out.println("\nMatriz ordenada pares a la derecha");
        for(int i : numeros)
            System.out.print(i + " ");

    }
}
