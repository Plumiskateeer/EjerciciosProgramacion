package capitulo04.bloque03.Ejercicio07_Rectangulo;

import javax.swing.*;

public class PruebaRectangulo {
    public static void main(String[] args) {

        int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura del rectangulo: "));
        int base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base del rectangulo: "));
        Rectangulo rect = new Rectangulo(altura, base);
        System.out.println(rect);
    }
}
