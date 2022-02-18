package examenes.examen18022022;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio02_CromoBaloncesto {
    private int id, puntos, rebotes;
    private String nombre;
    private static HashMap<Integer,Ejercicio02_CromoBaloncesto> coleccion = new HashMap<>();

    public Ejercicio02_CromoBaloncesto(int id, int puntos, int rebotes, String nombre) {
        this.id = id;
        this.puntos = puntos;
        this.rebotes = rebotes;
        this.nombre = nombre;
    }

    public static void main(String[]args){

        Ejercicio02_CromoBaloncesto cromo1 = new Ejercicio02_CromoBaloncesto(1,12,9,"Pepe");
        Ejercicio02_CromoBaloncesto cromo2 = new Ejercicio02_CromoBaloncesto(2,5,7,"Luisa");
        Ejercicio02_CromoBaloncesto cromo3 = new Ejercicio02_CromoBaloncesto(3,3,10,"Juan");

        coleccion.put(cromo1.getId(),cromo1);
        coleccion.put(cromo2.getId(),cromo2);
        coleccion.put(cromo3.getId(),cromo3);

        int opcion;
        do{
            opcion = menu();
            switch (opcion){
                case 1: imprimirCromos();break;
                case 2: anadirCromo();break;
                case 3: eliminarCromo();break;
                case 4: imprimirMayorAnotador();break;
                default: System.out.println("FIN DEL PROGRAMA");break;
            }
        }while(opcion !=0);
    }

    private static void imprimirMayorAnotador() {
        int mayor = 0, id = 0;
        for (Map.Entry<Integer, Ejercicio02_CromoBaloncesto> entry : coleccion.entrySet()) {
            if(entry.getValue().getPuntos() > mayor){
                mayor = entry.getValue().getPuntos();
                id = entry.getKey();
            }
        }
        System.out.println("El cromo con mas puntos es: "
                           + "\nNombre: " + coleccion.get(id).getNombre()
                           + "\nId: " + (coleccion.get(id).getId())
                           + "\nPuntos: " + (coleccion.get(id).getPuntos())
                           + "\nRebotes: " + (coleccion.get(id).getRebotes()));
    }

    private static void imprimirCromos() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Ejercicio02_CromoBaloncesto> entry : coleccion.entrySet()) {
            sb.append("ID cromo=" + entry.getKey() + ", Valor=" + entry.getValue().toString()).append("\n");
        }
        System.out.println(sb);
    }

    private static void anadirCromo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el cromo" +
                           "\nId del cromo: ");
        int id = sc.nextInt();
        System.out.println("Introduce los puntos obtenidos: ");
        int puntos = sc.nextInt();
        System.out.println("Introduce los rebotes realizados: ");
        int rebotes = sc.nextInt();
        System.out.println("Introduce el nombre del jugador: ");
        String nombre = sc.next();
        Ejercicio02_CromoBaloncesto nuevo = new Ejercicio02_CromoBaloncesto(id,puntos,rebotes,nombre);
        coleccion.put(nuevo.getId(),nuevo);
        System.out.println("CROMO AÑADIDO\n");
    }

    private static void eliminarCromo() {
        System.out.println("Introduce el id del cromo a eliminar: ");
        Scanner sc = new Scanner(System.in);
        coleccion.remove(sc.nextInt());
    }


    public static int menu(){
        int opcion;
        System.out.println("----MENU CROMOS BALONCESTO----" +
                           "\n0.Salir" +
                           "\n1.Visualizar los valores de los cromos" +
                           "\n2.Introducir un nuevo cromo" +
                           "\n3.Eliminar un cromo, especificando su id" +
                           "\n4.Imprimir en consola el jugador con mas puntos obtenidos\n" +
                           "Opcion elegida:");
        Scanner sc = new Scanner(System.in);
        opcion = sc.nextInt();
        return opcion;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getRebotes() {
        return rebotes;
    }

    public void setRebotes(int rebotes) {
        this.rebotes = rebotes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cromo{" +
               "id=" + id +
               ", puntos=" + puntos +
               ", rebotes=" + rebotes +
               ", nombre='" + nombre + '\'' +
               '}';
    }
}
