package capitulo05.bloque04;

public class Ejercicio03_NumDecimal {
    public static void main(String[] args) {
        int[] parteEntera = new int[20];
        int[] parteDecimal = new int[20];

        int cantidadDecimales = 0;

        // inicializo ambas matrices, filtro para saber cuantos decimales cumplen la condicion e imprimo los numeros
        System.out.println("Matriz original: ");
        for (int i = 0; i < parteEntera.length; i++) {
            parteEntera[i] = (int) (Math.round(Math.random() * (100)));
            parteDecimal[i] = (int) (Math.round(Math.random() * (100)));
            if (parteDecimal[i] < 50)
                cantidadDecimales++;
            System.out.print(parteEntera[i] + "." + parteDecimal[i] + " ");
        }

        System.out.println("\nHay " + cantidadDecimales + " numeros con parte decimal entre .00 y .49");
    }
}
