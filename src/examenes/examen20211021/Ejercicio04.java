package examenes.examen20211021;

public class Ejercicio04 {
    public static void main(String[] args) {

        // el primer for hace 10 veces el calculo de los divisores del numero aleatorio
        for (int j = 0; j < 10; j++) {
            int num = (int) (Math.round(Math.random() * (100)));
            System.out.println("\n\nEl numero es: " + num);
            System.out.print("Sus divisores: ");
            for (int i = 1; i < num; i++) { // este for calcula los divisores del numero y los imprime en pantalla
                if (num % i == 0)
                    System.out.print(i + " ");
            }
        }
    }
}
