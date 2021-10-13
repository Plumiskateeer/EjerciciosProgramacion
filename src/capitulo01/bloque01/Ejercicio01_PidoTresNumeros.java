package capitulo01.bloque01;

import javax.swing.*;

public class Ejercicio01_PidoTresNumeros {

    public static void main(String[] args) {
        String str = JOptionPane.showInputDialog("Introduzca un número entero: ");
        int num = Integer.parseInt(str);

        str = JOptionPane.showInputDialog("Introduzca un número decimal: ");
        float num2 = Float.parseFloat(str);

        str = JOptionPane.showInputDialog("Introduzca un número real: ");
        double num3 = Double.parseDouble(str);


        System.out.println("Números introducidos: " + num + " " + num2 + " " + num3);

    }

}
