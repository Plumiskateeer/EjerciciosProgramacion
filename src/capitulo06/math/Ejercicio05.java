package capitulo06.math;

import java.util.Calendar;
import java.util.TimeZone;

public class Ejercicio05 {
    public static void main(String[] args) {
        // Creamos calendar para hora de Roma
        Calendar roma = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));
        // Mostramos en pantalla
        System.out.println("Hora actual en Roma: " + roma.get(Calendar.HOUR_OF_DAY));

        // Creamos calendar para hora de Washington, pongo ny porque está en la misma zona horaria
        Calendar ny = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
        // Mostramos en pantalla
        System.out.println("Hora actual en Washington: " + ny.get(Calendar.HOUR_OF_DAY));

        // Para saber la diferencia horaria cogemos los milisegundos de las dos zonas
        // horarias
        // los restamos
        short horasDiferencia = (short) Math.abs(roma.get(Calendar.HOUR_OF_DAY) - ny.get(Calendar.HOUR_OF_DAY));

        System.out.println("Diferencia horaria: " + horasDiferencia);

//        Para buscar el id de las distintas zonas horarias
//        String zonasHorarias[] = TimeZone.getAvailableIDs();
//        for (String str : zonasHorarias)
//            System.out.println("Zona horaria: " + str);

    }
}
