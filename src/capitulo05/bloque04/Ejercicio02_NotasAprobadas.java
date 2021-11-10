package capitulo05.bloque04;

public class Ejercicio02_NotasAprobadas {
    public static void main(String[] args) {
        int[] matriz = new int[20];

        inicializarMatriz(matriz);
        calculoNotas(matriz);
    }

    public static void inicializarMatriz(int[] matriz){
        // inicializo e imprimo
        System.out.println("Matriz original: ");
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = (int) (Math.round(Math.random() * (10)));
            System.out.print(matriz[i] + " ");
        }
    }

    public static void calculoNotas(int[] matriz){
        float aprobados = 0;
        float suspensos = 0;

        for (int i : matriz)
            if (i >= 5)
                aprobados++;
            else suspensos++;

        System.out.println("\nEl % de aprobados es: " + ((aprobados/matriz.length)*100) + "\n" +
                "El % de suspensos es: " + (suspensos/matriz.length)*100);
    }
}
