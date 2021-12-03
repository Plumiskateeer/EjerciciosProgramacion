package examenes.examen03122021;

import java.util.Locale;

public class Ejercicio04_CharArraytoString {
    public static void main(String[] args) {
        char[] array = {'H', 'o', 'l', 'a', ' ', 'M', 'u', 'n', 'd', 'o'};
        System.out.println("Array original en minusculas: ");
        System.out.println(array);
        System.out.println("Array en minusculas y en String: \n" + minusculas(array));
    }

    public static String minusculas(char frase[]) {
        String sb = "";
        for (int i = 0; i < frase.length; i++) {
            if(frase[i]>= 65 && frase[i] <= 90)
            sb+=(char)(frase[i] + 32);
            else sb+=(frase[i]);
        }
        return sb;
    }
}
