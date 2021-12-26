//package capitulo05.bloque08;
//
//import javax.swing.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Ejercicio01_ListaInteger {
//    /**
//     * En el main se muestra un menu con opciones, y se llama al metodo correspondiente
//     *
//     * @param args default
//     */
//    public static void main(String[] args) {
//        List<String> texto = new ArrayList<>();
//        int num;
//
//        do {
//            System.out.println("------- EDITOR DE TEXTOS -------\n" +
//                               "1 : Añadir linea al texto\n" +
//                               "2 : Insertar una linea en una posicion\n" +
//                               "3 : Editar una linea\n" +
//                               "4 : Borrar una linea\n" +
//                               "5 : Cortar lineas de ciertas posiciones\n" +
//                               "6 : Pegar lineas en unas posiciones\n" +
//                               "7 : Imprimir el texto");
//
//            num = Integer.parseInt(JOptionPane.showInputDialog("Introduce la accion deseada: "));

//            switch (num) {
//                case 1 : {
//                    anadirLinea(texto);
//                }
//                case 2 : anadirLineaenPos(texto);
//                case 3 : editarLinea(texto);
//                case 4 : borrarLinea(texto);
//                case 5 : cortarParteDeTexto(texto);
//                case 6 : pegarParteDeTexto(texto);
//                case 7 : System.out.println("\n" + imprimirTexto(texto));
//                default : System.out.println("FIN DEL PROGRAMA");
//            }
//
//        } while (num != 0);
//
//    }
//}
