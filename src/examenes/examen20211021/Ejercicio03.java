package examenes.examen20211021;

public class Ejercicio03 {
    public static void main(String[] args) {

        int cont = 0;
        // mientras cont menor que 10, sigo creando el num aleatorio y lo imprimo si es par y si esta en los limites establecidos
        // tiene que estar entre 20 y 30 o entre 40 y 50
        while (cont < 10) {
            int num = ((int) (Math.round((Math.random() * (50 - 20)) + 20)));
            if ((num <= 30 || num >= 40) && num % 2 == 0) {
                System.out.print(num + " ");
                cont++;
            }
        }
    }
}
