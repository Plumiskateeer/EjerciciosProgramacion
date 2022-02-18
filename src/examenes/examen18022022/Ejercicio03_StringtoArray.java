package examenes.examen18022022;

import java.util.Scanner;

public class Ejercicio03_StringtoArray {
    public static void main(String[] args) {

        String frase = null;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Introduce una frase comenzando con espacios: ");
            frase = sc.nextLine();
        }while(!Character.isWhitespace(frase.charAt(0)));

        imprimirResultadoPalabras(prepararFrase(frase));

    }

    public static String[] prepararFrase(String frase){
        frase = frase.trim();
        String palabras[] = frase.split(" ");

        return palabras;
    }

    public static void imprimirResultadoPalabras(String[] palabras){
        for (String palabra : palabras) {
            int numMin = 0;
            int numMayus = 0;
            int numDigits = 0;

            for (int i = 0; i < palabra.length(); i++) {
                if (Character.isLowerCase(palabra.charAt(i))) numMin++;
                if (Character.isUpperCase(palabra.charAt(i))) numMayus++;
                if (Character.isDigit(palabra.charAt(i))) numDigits++;
            }

            System.out.println("Palabra: " + palabra + "\n\tLetras: " + (numMayus + numMin) +
                               "\n\tMayúsculas: " + numMayus + "\n\tMinúsculas: " + numMin +
                               "\n\tDígitos: " + numDigits);
        }
    }
}
