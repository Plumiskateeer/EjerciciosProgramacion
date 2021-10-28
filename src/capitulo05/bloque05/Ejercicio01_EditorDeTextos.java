package capitulo05.bloque05;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio01_EditorDeTextos {
    private static List<String> lineasCortadas; // CAMBIAR ESTO POR OTRO ARRAYLIST Y LUEGO PARA PEGAR HACER ADD.ALL EN CIERTA POSICION

    /**
     * En el main se muestra un menu con opciones, y se llama al metodo correspondiente
     *
     * @param args default
     */
    public static void main(String[] args) {
        List<String> texto = new ArrayList<>();
        int num;

        do {
            System.out.println("""
                    ------- EDITOR DE TEXTOS -------
                    1 : Añadir linea al texto
                    2 : Insertar una linea en una posicion
                    3 : Editar una linea
                    4 : Borrar una linea
                    5 : Cortar lineas de ciertas posiciones
                    6 : Pegar lineas en unas posiciones
                    7 : Imprimir el texto""");

            num = Integer.parseInt(JOptionPane.showInputDialog("Introduce la accion deseada: "));

            switch (num) {
                case 1 -> anadirLinea(texto);
                case 2 -> anadirLineaenPos(texto);
                case 3 -> editarLinea(texto);
                case 4 -> borrarLinea(texto);
                case 5 -> cortarParteDeTexto(texto);
                case 6 -> pegarParteDeTexto(texto);
                case 7 -> System.out.println("\n" + imprimirTexto(texto));
                default -> System.out.println("FIN DEL PROGRAMA");
            }

        } while (num != 0);

    }

    /**
     * Annadir linea al texto
     *
     * @param texto arraylist texto
     */
    public static void anadirLinea(List<String> texto) {
        texto.add(JOptionPane.showInputDialog("Introduce la linea: "));
    }

    /**
     * Annadir linea en x posicion
     *
     * @param texto arraylist texto
     */
    public static void anadirLineaenPos(List<String> texto) {
        texto.set(Integer.parseInt(JOptionPane.showInputDialog
                        ("Introduce el indice en el cual quieres introducir una linea")),
                JOptionPane.showInputDialog("Introduce la linea: "));
    }

    /**
     * Editar linea del texto
     *
     * @param texto arraylist texto
     */
    public static void editarLinea(List<String> texto) {
        texto.set(Integer.parseInt(JOptionPane.showInputDialog
                        ("Introduce el indice de la linea a modificar: ")),
                JOptionPane.showInputDialog("Introduce la linea modificada: "));
    }

    /**
     * Borrar linea del texto
     *
     * @param texto arraylist texto
     */
    public static void borrarLinea(List<String> texto) {
        texto.remove(Integer.parseInt(JOptionPane.showInputDialog
                ("Introduce el indice de la linea que quieres borrar: ")));
    }

    /**
     * Metodo auxiliar para borrar x linea
     *
     * @param texto  arraylist texto
     * @param indice indice de la linea a borrar
     */
    public static void borrarLinea(List<String> texto, int indice) {
        texto.remove(indice);
    }

    /**
     * Cortar x lineas del texto en un intervalo
     *
     * @param texto arraylist texto
     */
    public static void cortarParteDeTexto(List<String> texto) {
        int limInf, limSup;
        do {
            limInf = Integer.parseInt(JOptionPane.showInputDialog("Introduce el indice inferior para cortar: "));
            limSup = Integer.parseInt(JOptionPane.showInputDialog("Introduce el indice superior para cortar: "));
        } while (limInf > limSup || limInf < 0);

        lineasCortadas = new ArrayList<>();
        for (int i = 0; i <= limSup - limInf; i++) {
            lineasCortadas.add(texto.get(limInf));
            borrarLinea(texto, limInf);
        }
    }

    /**
     * Pegar el texto anteriormente cortado
     *
     * @param texto arraylist texto
     */
    public static void pegarParteDeTexto(List<String> texto) {
        texto.addAll(lineasCortadas);
        lineasCortadas.clear();
    }

    /**
     * Imprime el texto entero
     *
     * @param texto arraylist texto
     * @return StrinBuilder del texto to String
     */
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
