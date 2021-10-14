package capitulo04.bloque03.Ejercicio06_Restaurante;

import java.util.Scanner;

public class Plato {
    private String eleccion;
    private int orden;
    private int precio;
    private final int nPlato;

    public Plato(int orden) {
        Scanner sc = new Scanner(System.in);
        this.orden = orden;
        this.precio = 0;

        switch (orden) {
            case 1 -> {
                System.out.println("Elige el primer plato: (salmorejo, ensalada o sopa)");
                eleccion = sc.nextLine();
                nPlato = 1;
                if (eleccion.equals("salmorejo")) precio = 4;
                else if (eleccion.equals("ensalada")) precio = 6;
                else precio = 5;
            }
            case 2 -> {
                System.out.println("Elige el segundo plato: (paella, pollo o tortilla)");
                eleccion = sc.nextLine();
                nPlato = 2;
                if (eleccion.equals("paella")) precio = 6;
                else if (eleccion.equals("pollo")) precio = 8;
                else precio = 5;
            }
            case 3 -> {
                System.out.println("Elige el tercer plato: (helado, tarta o tiramisu)");
                eleccion = sc.nextLine();
                nPlato = 3;
                if (eleccion.equals("helado")) precio = 3;
                else if (eleccion.equals("tarta")) precio = 4;
                else precio = 5;
            }
            default -> throw new IllegalStateException("Valor inesperado: " + orden);
        }
    }

    public String getEleccion() {
        return eleccion;
    }

    public void setEleccion(String eleccion) {
        this.eleccion = eleccion;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getPrecio() {
        return this.precio;
    }

    public String toString() {
        String cadena;

        if (nPlato == 1) cadena = "El primer plato es: ";
        else if (nPlato == 2) cadena = "El segundo plato es: ";
        else cadena = "El tercer plato es: ";

        return (cadena + eleccion + "\n");
    }

}
