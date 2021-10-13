package capitulo01.bloque01;

import javax.swing.*;

public class Ejercicio06_CalcularCuotaMensual {

    public static void main(String[] args) {
        String str = JOptionPane.showInputDialog("Introduzca el importe a hipotecar: ");
        float importe = Float.parseFloat(str);

        str = JOptionPane.showInputDialog("Introduzca el numero de meses: ");
        float n = Float.parseFloat(str);

        str = JOptionPane.showInputDialog("Introduce el Euribor: ");
        float eur = Float.parseFloat(str);

        str = JOptionPane.showInputDialog("Introduce el diferencial: ");
        float dif = Float.parseFloat(str);

        float ianual = eur + dif;

        double im = (ianual / 12) / 100;

        double cmensual = importe * (((im * Math.pow((1 + im), n))) / (Math.pow((1 + im), n) - 1));

        System.out.println("La cuota mensual es de: " + cmensual + " $");
        // cuota mensual = capital*((Im*(1+Im)^N/((1+Im)^N)-1)
        // (Im)interes mensual = (interes anual/12)/100
        // interes anual= euribor + diferencial(ganancia del banco)
    }

}
