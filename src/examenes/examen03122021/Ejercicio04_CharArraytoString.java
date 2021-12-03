package examenes.examen03122021;

import java.util.Locale;

public class Ejercicio04_CharArraytoString {
    public static void main(String[] args) {
        char[] array = {'H', 'O', 'L', 'A', ' ', 'M', 'U', 'N', 'D', 'O'};
        System.out.println("Array original en minusculas: ");
        System.out.println(array);
        System.out.println("Array en minusculas y en String: \n" + minusculas(array));
    }

    public static String minusculas(char frase[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < frase.length; i++) {
            sb.append(frase[i]);
        }
        return sb.toString().toLowerCase(Locale.ROOT);
    }
}
