package capitulo07;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utils {


    public static int obtenerNumeroAzar() {
        return (int) Math.round(Math.random() * 100);
    }

    public static int obtenerNumeroAzar(int min, int max) {
        return (int) Math.round(Math.random() * (max - min)) + min;
    }

    public static void main(String args[]) {
        for (int i = 0; i < 1000; i++) {
            System.out.print(obtenerNumeroAzar(-2, 5) + " ");
        }
    }


    public static int obtenerEntero() {
        int numero = 0;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            numero = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numero;
    }


}
