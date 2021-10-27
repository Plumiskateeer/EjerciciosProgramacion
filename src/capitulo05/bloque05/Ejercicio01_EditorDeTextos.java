package capitulo05.bloque05;

import javax.swing.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio01_EditorDeTextos {
    private static String[] lineasCortadas; // CAMBIAR ESTO POR OTRO ARRAYLIST Y LUEGO PARA PEGAR HACER ADD.ALL EN CIERTA POSICION

    public static void main(String[] args) {
        List<String> texto = new ArrayList<>();

        int limInf = 0, limSup = 0;
        int num;
        do {
            System.out.println("------- EDITOR DE TEXTOS -------\n" +
                    "1 : Añadir linea al texto\n" +
                    "2 : Insertar una linea en una posicion\n" +
                    "3 : Editar una linea\n" +
                    "4 : Borrar una linea\n" +
                    "5 : Cortar lineas de ciertas posiciones\n" +
                    "6 : Pegar lineas en unas posiciones\n" +
                    "7 : Imprimir el texto");

            num = Integer.parseInt(JOptionPane.showInputDialog("Introduce la accion deseada: "));


            switch (num) {
                case 1 -> anadirLinea(texto);
                case 2 -> anadirLineaenPos(texto);
                case 3 -> editarLinea(texto);
                case 4 -> borrarLinea(texto);
                case 5 -> cortarParteDeTexto(texto, limInf, limSup);
                case 6 -> pegarParteDeTexto(texto, limInf, limSup);
                case 7 -> System.out.println("\n"+imprimirTexto(texto));
                default -> System.out.println("VALOR ERRONEO");
            }

        } while (num != 0);

    }

    public static void anadirLinea(List<String> texto) {
        texto.add(JOptionPane.showInputDialog("Introduce la linea: "));
    }

    public static void anadirLineaenPos(List<String> texto) {
        texto.set(Integer.parseInt(JOptionPane.showInputDialog
                        ("Introduce el indice en el cual quieres introducir una linea")),
                JOptionPane.showInputDialog("Introduce la linea: "));
    }

    public static void editarLinea(List<String> texto) {
        texto.set(Integer.parseInt(JOptionPane.showInputDialog
                        ("Introduce el indice de la linea a modificar: ")),
                JOptionPane.showInputDialog("Introduce la linea modificada: "));
    }

    public static void borrarLinea(List<String> texto) {
        texto.remove(Integer.parseInt(JOptionPane.showInputDialog
                ("Introduce el indice de la linea que quieres borrar: ")));
    }

    public static void borrarLinea(List<String> texto, int indice) {
        texto.remove(indice);
    }

    public static void cortarParteDeTexto(List<String> texto, int limInf, int limSup) {
        do {
            limInf = Integer.parseInt(JOptionPane.showInputDialog("Introduce el indice inferior para cortar: "));
            limSup = Integer.parseInt(JOptionPane.showInputDialog("Introduce el indice superior para cortar: "));
        } while (limInf > limSup || limInf < 0);

        lineasCortadas = new String[limSup - limInf];
        for (int i = limInf; i < limSup; i++) {
            lineasCortadas[i - limInf] = texto.get(i);
            borrarLinea(texto, i);
        }
    }
    // FALTA MODIFICAR ESTA PARTE, PEGA EL TEXTO MAL

    public static void pegarParteDeTexto(List<String> texto, int limInf, int limSup) {
        for (int i = limInf; i < limSup; i++) {
            texto.set(i, lineasCortadas[i - limInf]);
        }
    }

    public static String imprimirTexto(List<String> texto) {
        StringBuilder sb = new StringBuilder();
        int cont = 0;
        for (String i : texto) {
            sb.append(cont).append(": ").append(i);
            sb.append("\n");
            cont++;
        }
        return sb.toString();
    }
}
