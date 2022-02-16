package capitulo06.wrappers;

import java.util.Scanner;

public class Ejercicio02_Contrasena {
    private static boolean valida = false;
    private static boolean hayMayus = false;
    private static boolean hayMinus = false;
    private static boolean hayDigit = false;
    private static boolean hayNoAlfa = false;
    private static String password;

    public static void main(String[] args) {
        do {
            password = pedirPassword();
            comprobarPassword(password);
        } while (!valida);
        System.out.println("Contraseña correcta: " + password);
    }

    private static void comprobarPassword(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) hayDigit = true;
            if (Character.isLowerCase(password.charAt(i))) hayMinus = true;
            if (Character.isUpperCase(password.charAt(i))) hayMayus = true;
            if (Character.isWhitespace(password.charAt(i))) hayNoAlfa = true;
        }

        if (hayMayus && hayMinus && hayDigit && hayNoAlfa) {
            valida = true;
        }
        else System.out.println("Contraseña incorrecta");
    }

    private static String pedirPassword() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una contraseña con los siguientes requisitos:\n-Al menos una mayuscula.\n-Al menos una minuscula"
                           + "\n-Al menos un digito.\n-Al menos un caracter no alfanumerico.");
        return sc.nextLine();
    }
}
