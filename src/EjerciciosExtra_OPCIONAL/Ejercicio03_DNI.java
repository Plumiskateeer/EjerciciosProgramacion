package EjerciciosExtra_OPCIONAL;

import javax.swing.*;

public class Ejercicio03_DNI {
    public static void main(String[] args) {
        int num;

        String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

        do {
            num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un DNI para calcular su letra: "));
        } while (num < 10000000 || num > 99999999);

        System.out.println("El dni es " + num + letras[num % 23]);
    }
}
