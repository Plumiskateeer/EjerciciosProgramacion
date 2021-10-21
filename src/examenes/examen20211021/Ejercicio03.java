package examenes.examen20211021;

public class Ejercicio03 {
    public static void main(String[] args) {

        int cont = 0;
        // mientras cont menor que 10, sigo creando el num aleatorio y lo imprimo si es par
        while (cont < 10) {
            int num = ((int) (Math.round((Math.random() * (50 - 20)) + 20)));
            if (num % 2 == 0) {
                if (num <= 30 || num >= 40) {
                    System.out.print(num + " ");
                    cont++;
                }
            }
        }
    }
}
