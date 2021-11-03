package EjerciciosExtra;

import javax.swing.*;

public class Ejercicio02_DesplazarTodoMenosIntervalo {
    public static void main(String[] args){
        int [] numeros = new int[10];

        // ESTE FALTA TERMINARLO
        System.out.println("Matriz original");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero"));
            System.out.println(i + ": " + numeros[i]);
        }

        int inicial, posterior;
        do {
            inicial = Integer.parseInt(JOptionPane.showInputDialog("Introduce un limite inferior: "));
            posterior = Integer.parseInt(JOptionPane.showInputDialog("Introduce un limite superior: "));
        }while(inicial > posterior | inicial < 0 | posterior > 9);

        int cont = 1, ultimo;
        while(numeros[numeros.length - cont] < posterior) {
            cont++;
        }
        ultimo = numeros[numeros.length - cont];


        // desplazo la matriz desde atras hacia delante
        for (int i = numeros.length - 1; i >= 0; i--) {
            if ((i - 1) >= 0 && !(i >= inicial && i <=posterior))
                numeros[i] = numeros[i - 1];
        }

        int j = 0;
        if(inicial == 0)
            j = posterior+1;
        numeros[j] = ultimo;

        System.out.println("Matriz ordenada dejando el intervalo intacto: ");
        for(int i : numeros)
            System.out.print(i + " ");
    }
}
