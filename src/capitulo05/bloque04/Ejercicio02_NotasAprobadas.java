package capitulo05.bloque04;

public class Ejercicio02_NotasAprobadas {
    public static void main(String[] args) {
        int[] matriz = new int[20];
        float aprobados = 0;
        float suspensos = 0;

        // inicializo e imprimo
        System.out.println("Matriz original: ");
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = (int) (Math.round(Math.random() * (10)));
            System.out.print(matriz[i] + " ");
        }

        for (int i : matriz)
            if (i >= 5)
                aprobados += 1;
            else suspensos += 1;

        System.out.println("\nEl % de aprobados es: " + ((aprobados/matriz.length)*100) + "\n" +
                "El % de suspensos es: " + (suspensos/matriz.length)*100);
    }
}
