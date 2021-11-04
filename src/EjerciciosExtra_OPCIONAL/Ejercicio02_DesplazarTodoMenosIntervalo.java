package EjerciciosExtra_OPCIONAL;

import javax.swing.*;

public class Ejercicio02_DesplazarTodoMenosIntervalo {
    public static void main(String[] args) {
        int[] numeros = new int[10];

        // imprimo matriz original y le introduzco los numeros
        System.out.println("Matriz original");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero"));
            System.out.println(i + ": " + numeros[i]);
        }

        // aqui pido numeros del intervalo hasta que sean coherentes
        int inicial, posterior;
        do {
            inicial = Integer.parseInt(JOptionPane.showInputDialog("Introduce un limite inferior: "));
            posterior = Integer.parseInt(JOptionPane.showInputDialog("Introduce un limite superior: "));
        } while (inicial > posterior | inicial < 0 | posterior > 9);

        int ultimo = numeros[numeros.length - 1];
        if (posterior == numeros.length - 1)
            ultimo = numeros[inicial - 1];


        // desplazo la matriz desde atras hacia delante
        for (int i = numeros.length - 1; i >= 0; i--) {
            if ((i - 1) >= 0 && (i < inicial | i - 1 > posterior))
                numeros[i] = numeros[i - 1];
            else if ((i - posterior) >= 0 && (i < inicial | i - 1 >= posterior))
                numeros[i] = numeros[i - posterior - 1];
        }

        int j = 0;
        if (inicial == 0)
            j = posterior + 1;
        numeros[j] = ultimo;

        System.out.println("Intervalo : " + inicial + "-" + posterior);
        System.out.println("Matriz ordenada dejando el intervalo intacto: ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(i + ": " + numeros[i]);
        }
    }
}
