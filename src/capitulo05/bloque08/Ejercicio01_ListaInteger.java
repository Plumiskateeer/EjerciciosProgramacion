package capitulo05.bloque08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio01_ListaInteger {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> lista = new ArrayList<>();
        int num;

        do {
            System.out.println("------- OPERAR SOBRE LISTA -------\n" +
                    "0 : Finalizar programa\n" +
                    "1 : Crear aleatoriamente la lista de valores\n" +
                    "2 : Calcular suma, media, mayor y menor\n" +
                    "3 : Agregar una cantidad de nuevos valores\n" +
                    "4 : Eliminar elementos cuyo valor este en un intervalo\n" +
                    "5 : Imprimir la lista\n" +
                    "Introduce la accion deseada: ");

            num = sc.nextInt();

            switch (num) {
                case 1 : crearListaValAleatorios(lista); break;
                case 2 : calcularMedidasLista(lista); break;
                case 3 : agregarValLista(lista); break;
                case 4 : eliminarValIntervaloLista(lista); break;
                case 5 : System.out.println("\n" + imprimirLista(lista) + "\n"); break;
                default : System.out.println("******* FIN DEL PROGRAMA *******"); break;
            }

        } while (num != 0);


    }

    public static void crearListaValAleatorios(List<Integer> lista) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la longitud de la lista: ");
        int longitud = sc.nextInt();
        System.out.println("Introduce el valor minimo de la lista: ");
        int min = sc.nextInt();
        System.out.println("Introduce el valor maximo de la lista: ");
        int max = sc.nextInt();

        lista.clear();

        for (int i = 0; i < longitud; i++) {
            lista.add((int) Math.round(Math.random()*(max-min)+min));
        }

    }

    public static void calcularMedidasLista(List<Integer> lista) {
        int suma = 0, mayor = -10000, menor = 10000;

        for(int i : lista){
            suma+=i;
            if (i < menor) menor = i;
            else if (i > mayor) mayor = i;
        }
        System.out.println("--MEDIDAS DE LA LISTA--");
        System.out.println("Suma: " + suma);
        System.out.println("Menor: " + menor);
        System.out.println("Mayor: " + mayor);
        System.out.println("Media: " + suma / lista.size());
    }

    public static void agregarValLista(List<Integer> lista) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la cantidad de valores a agregar: ");
        int cantidad = sc.nextInt();
        System.out.println("Introduce la posicion en la que insertar los valores: ");
        int posicion = sc.nextInt();
        System.out.println("Introduce el valor minimo del intervalo: ");
        int min = sc.nextInt();
        System.out.println("Introduce el valor maximo del intervalo: ");
        int max = sc.nextInt();

        for (int i = posicion; i < cantidad+posicion; i++) {
            lista.add(i,(int) Math.round(Math.random()*(max-min)+min));
        }

    }
    public static void eliminarValIntervaloLista(List<Integer> lista) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el indice minimo del intervalo de la lista: ");
        int min = sc.nextInt();
        System.out.println("Introduce el indice maximo del intervalo de la lista: ");
        int max = sc.nextInt();

        int borrados = 0;
        for (int i = min; i <= max; i++) {
            lista.remove(min);
            borrados++;
        }
        System.out.println("Se han borrado " + borrados + " elementos de la lista\n");
    }

    public static String imprimirLista(List<Integer> lista) {
        StringBuilder sb = new StringBuilder();
        int cont = 0;
        for (int i : lista) {
            sb.append(cont).append(": ").append(i);
            sb.append("\n");
            cont++;
        }
        return sb.toString();
    }
}
