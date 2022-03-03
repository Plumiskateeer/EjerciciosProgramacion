package capitulo06.math;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ejercicio04 {
    public static void main(String[]args){
        String fechaUs = JOptionPane.showInputDialog("Introduzca la fecha:");
        // Creamos formato
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        Date fechaPars = null;
        try {
            fechaPars = formato.parse(fechaUs);// Le damos formato
        } catch (ParseException e) {
            System.out.println("Error en el parseo de la fecha");// Creamos mensaje de error por si no funcionase
            e.printStackTrace();
        }
        System.out.println("Fecha parseada: " + formato.format(fechaPars));// Mostramos en pantalla

        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fechaPars);

        // Sacamos año
        System.out.println("\nAño con Calendar: " + calendario.get(Calendar.YEAR));
        System.out.println("Año con Date: " + new SimpleDateFormat("yyyy").format(fechaPars));

        // Sacamos mes
        System.out.println("\nMes con Calendar: " + calendario.get(Calendar.MONTH));
        System.out.println("Mes con Date: " + new SimpleDateFormat("MM").format(fechaPars));

        // Sacamos día
        System.out.println("\nDía con Calendar: " + calendario.get(Calendar.DAY_OF_MONTH));
        System.out.println("Día con Date: " + new SimpleDateFormat("dd").format(fechaPars));

        // Sacamos hora
        System.out.println("\nHora con Calendar: " + calendario.get(Calendar.HOUR_OF_DAY));
        System.out.println("Hora con Date: " + new SimpleDateFormat("H").format(fechaPars));

        // Sacamos minuto
        System.out.println("\nMinuto con Calendar: " + calendario.get(Calendar.MINUTE));
        System.out.println("Minuto con Date: " + new SimpleDateFormat("m").format(fechaPars));

        // Sacamos segundo
        System.out.println("\nSagundo con Calendar: " + calendario.get(Calendar.SECOND));
        System.out.println("Segundo con Date: " + new SimpleDateFormat("s").format(fechaPars));

        // Creamos nuevas fechas con calendar

        System.out.println("Fecha insertada:" + calendario.getTime());

        // Añadimos 3 días
        calendario.add(Calendar.DAY_OF_MONTH, 3);
        System.out.println("Fecha insertada más 3 días: " + calendario.getTime());

        // Añadimos 2 semanas
        calendario.add(Calendar.WEEK_OF_YEAR, 2);
        System.out.println("Fecha insertada más 2 semanas: " + calendario.getTime());

        // Añadimos 300 días
        calendario.add(Calendar.DAY_OF_YEAR, 300);
        System.out.println("Fecha insertada más 300 días: " + calendario.getTime());

        // Añadimos 4 años
        calendario.add(Calendar.YEAR, 4);
        System.out.println("Fecha insertada más 4 años: " + calendario.getTime());
    }
}
