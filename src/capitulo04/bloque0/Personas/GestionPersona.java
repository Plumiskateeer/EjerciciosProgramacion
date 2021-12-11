package capitulo04.bloque0.Personas;

import javax.swing.*;

public class GestionPersona {
    public static void main(String[] args) {
        Persona[] personas = new Persona[3];

        int opcion;
        do {
            System.out.println("\n-------MENU PERSONAS---------");
            System.out.println("\t0:Salir");
            System.out.println("\t1:Introducir persona");
            System.out.println("\t2:Mostrar personas");
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Introduce una opcion:"));
            switch (opcion) {
                case 0: {
                    System.out.println("\nFin del programa");
                    break;
                }
                case 1: {
                    introducirPersona(personas);
                    break;
                }
                case 2: {
                    mostrarPersonas(personas);
                }
                default: break;

            }
        } while (opcion != 0);

    }

    private static void mostrarPersonas(Persona[] personas) {
        boolean hayPersonas = false;
        System.out.println("\n"+"--PERSONAS ALMACENADAS--");
        for(Persona i : personas) {
            if(i!=null) {
                System.out.println(i);
                hayPersonas = true;
            }
        }
        if (!hayPersonas)
            System.out.println("\nNo hay ninguna persona para mostrar");
    }

    private static void introducirPersona(Persona[] personas) {

        boolean hayHueco = false;

        int pos = 0;
        int posNula = 0;
        for(Persona i : personas) {
            if (i == null) {
                hayHueco = true;
                posNula = pos;
            }
            pos++;
        }
        if (hayHueco){
            personas[posNula] = new Persona();
            String dato = JOptionPane.showInputDialog("Introduce el nombre: ");
            personas[posNula].setNombre(dato);
            dato = JOptionPane.showInputDialog("Introduce el apellido: ");
            personas[posNula].setApellido(dato);
            dato = JOptionPane.showInputDialog("Introduce el dni: ");
            personas[posNula].setDni(dato);
            dato = JOptionPane.showInputDialog("Introduce la direccion: ");
            personas[posNula].setDireccion(dato);
            dato = JOptionPane.showInputDialog("Introduce el telefono: ");
            personas[posNula].setTelefono(dato);
            System.out.println("\nHas introducido una persona");
        }else
            System.out.println("\nNo hay hueco para introducir persona");
    }


}
