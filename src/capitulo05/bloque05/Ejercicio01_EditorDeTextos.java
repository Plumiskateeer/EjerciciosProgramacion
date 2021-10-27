package capitulo05.bloque05;

import javax.swing.*;
import java.util.ArrayList;

public class Ejercicio01_EditorDeTextos {
    public static void main(String[] args){
        ArrayList<String> texto = new ArrayList<>();
        int num;
        do{
            System.out.println("------- EDITOR DE TEXTOS -------");
            System.out.println("1 : Añadir linea al texto");
            System.out.println("2 : Insertar una linea en una posicion");
            System.out.println("3 : Editar una linea");
            System.out.println("4 : Borrar una linea");
            System.out.println("5 : Cortar lineas de ciertas posiciones");
            System.out.println("6 : Pegar lineas en unas posiciones");
            System.out.println("7 : Imprimir el texto");


            num = Integer.parseInt(JOptionPane.showInputDialog("Introduce la accion deseada: "));
        }while(num!=0);

    }
}
