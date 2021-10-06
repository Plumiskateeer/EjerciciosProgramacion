package capitulo04.bloque03.restaurante;

import java.util.Scanner;

public class Plato {
    private String eleccion;
    private int orden;
    private int precioPrimero, precioSegundo, precioTercero;

    public Plato(int orden){
        Scanner sc = new Scanner(System.in);
        this.orden = orden;
        switch (orden){
            case 1 -> {
                System.out.println("Elige el primer plato: (salmorejo, ensalada o sopa)");
                eleccion = sc.nextLine();
                if(eleccion.equals("salmorejo")) precioPrimero = 4;
                    else if(eleccion.equals("ensalada")) precioPrimero = 6;
                        else precioPrimero = 5;
            }
            case 2 -> {
                System.out.println("Elige el segundo plato: (paella, pollo o tortilla)");
                eleccion = sc.nextLine();
                if(eleccion.equals("paella")) precioSegundo = 6;
                    else if(eleccion.equals("pollo")) precioSegundo = 8;
                        else precioSegundo = 5;
            }
            case 3-> {
                System.out.println("Elige el tercer plato: (helado, tarta o tiramisu)");
                eleccion = sc.nextLine();
                if(eleccion.equals("helado")) precioTercero = 3;
                    else if(eleccion.equals("tarta")) precioTercero = 4;
                        else precioTercero = 5;
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

}
