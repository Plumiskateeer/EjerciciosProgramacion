package capitulo05.bloque04;

public class Ejercicio03_NumDecimal {
    public static void main(String[] args) {
        float[] numeros = new float[20];

        decimalesEntre0y49(numeros);
    }

    public static void decimalesEntre0y49(float[] numeros){
        int cantidadDecimales = 0;

        // inicializo ambas matrices, filtro para saber cuantos decimales cumplen la condicion e imprimo los numeros
        System.out.println("Matriz original: ");
        for (int i = 0; i < numeros.length; i++) {
            int num = (int) (Math.round(Math.random() * 9900) + 100);
            numeros[i] = (float) num/100;
            num = num/100;
            if (numeros[i]-num < 0.50) {
                cantidadDecimales++;
                System.out.print("**");
            }
            System.out.print(numeros[i] + " ");
        }

        System.out.println("\nHay " + cantidadDecimales + " numeros con parte decimal entre .00 y .49");
    }
}
