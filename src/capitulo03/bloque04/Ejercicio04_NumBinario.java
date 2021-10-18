package capitulo03.bloque04;

import javax.swing.*;

public class Ejercicio04_NumBinario {
    public static void main(String[] args) {

        int num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero para pasarlo a binario: "));
        int i = 128;
        while (i > 0) {
            if ((num & i) != 0)
                System.out.print(1);
            else System.out.print(0);
            i /= 2;
        }
    }
}
