package capitulo05.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    private static HashMap<String,Articulo> articulos = new HashMap<>();

    public static void main(String[]args){
        int opcion;
        do{
        opcion = menu();
        switch (opcion){
            case 1: imprimirArticulos();break;
            case 2: anadirArticulo();break;
            case 3: eliminarArticulo();break;
            case 4: actualizarArticulo();break;
            default: System.out.println("FIN DEL PROGRAMA");break;
        }
        }while(opcion !=0);

    }

    private static void imprimirArticulos() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Articulo> entry : articulos.entrySet()) {
            sb.append("key=" + entry.getKey() + ", value=" + entry.getValue()).append("\n");
        }
        System.out.println(sb);
    }

    private static void anadirArticulo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el articulo" +
                           "Codigo de barras: ");
        String codigo = sc.nextLine();
        System.out.println("Introduce el numero de estante: ");
        int numEstante = sc.nextInt();
        System.out.println("Introduce la cantidad en stock: ");
        int cantidad = sc.nextInt();
        Articulo nuevo = new Articulo(codigo,numEstante,cantidad);
        articulos.put(nuevo.getCodigo(),nuevo);
        System.out.println("ARTICULO AÑADIDO\n");
    }

    private static void eliminarArticulo() {
        System.out.println("Introduce el codigo del articulo a eliminar: ");
        Scanner sc = new Scanner(System.in);
        articulos.remove(sc.nextLine());
    }

    private static void actualizarArticulo() {
        System.out.println("Introduce el codigo del articulo para actualizar: ");
        Scanner sc = new Scanner(System.in);
        String codigo = sc.nextLine();
        System.out.println("Introduce el nuevo numero de estante: ");
        int numEstante = sc.nextInt();
        System.out.println("Introduce la nueva cantidad: ");
        int cantidad = sc.nextInt();
        Articulo modificado = new Articulo(codigo, numEstante, cantidad);
        articulos.put(codigo,modificado);
        System.out.println("ARTICULO MODIFICADO");
    }


    public static int menu(){
        int opcion;
        System.out.println("----MENU----" +
                           "\n0.Salir" +
                           "\n1.Lista de articulos" +
                           "\n2.Crear nuevo articulo" +
                           "\n3.Eliminar articulo" +
                           "\n4.Actualizar un articulo\n" +
                           "Opcion elegida:");
        Scanner sc = new Scanner(System.in);
        opcion = sc.nextInt();
        return opcion;
    }
}
