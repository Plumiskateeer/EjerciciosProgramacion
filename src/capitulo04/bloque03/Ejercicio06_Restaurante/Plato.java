package capitulo04.bloque03.Ejercicio06_Restaurante;

import java.util.Scanner;

public class Plato {
    private String eleccion;
    private int precio;
    private final int nPlato;

    /**
     * Constructor general plato
     *
     * @param orden puede ser 1, 2, 3 siendo respectivamente primer plato, segundo plato, tercer plato
     */
    public Plato(int orden) {
        Scanner sc = new Scanner(System.in);
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

    /**
     *
     * @return eleccion plato, primero segundo
     */
    public String getEleccion() {
        return eleccion;
    }

    /**
     *
     * @param eleccion introducir eleccion plato
     */
    public void setEleccion(String eleccion) {
        this.eleccion = eleccion;
    }

    /**
     *
     * @return precio plato
     */
    public int getPrecio() {
        return this.precio;
    }

    /**
     *
     * @return toString plato, que orden de plato es y que eleccion hemos tomado
     */
    public String toString() {
        String cadena;

        if (nPlato == 1) cadena = "El primer plato es: ";
        else if (nPlato == 2) cadena = "El segundo plato es: ";
        else cadena = "El tercer plato es: ";

        return (cadena + eleccion + "\n");
    }

}
