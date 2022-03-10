package examenes.examen10032022;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Principal {
    private static final int RONDAS = 10;
    private static final int TIROS = 3;
    private static List<Jugador> jugadores = new ArrayList<>();
    private static Diana diana = new Diana();
    private static Properties propiedades = null;

    public static void main(String[]args) throws TiroFallidoException {

        Jugador j1 = new Jugador("Pepe", 0);
        Jugador j2 = new Jugador("Maria", 0);
        Jugador j3 = new Jugador("Raul", 0);
        Jugador j4 = new Jugador("Araceli", 0);

        jugadores.add(j1);
        jugadores.add(j2);
        jugadores.add(j3);
        jugadores.add(j4);

        System.out.println(getPropiedades().getProperty("NOMBREDIANA"));
        menuJuego();
        System.out.println(podium());

    }

    public static void menuJuego() throws TiroFallidoException {
        Scanner sc = new Scanner(System.in);

        System.out.println("------JUEGO DE DIANA-----");
        for (int j = 0; j < RONDAS; j++) {
            for(int i = 0; i<jugadores.size(); i++) {
                System.out.println("INDICES Y VALORES DE LA DIANA\n" + diana+
                                   "\n------RONDA " + (j + 1) + "/10--------");
                for(int k = 1; k <= TIROS; k++) {
                    System.out.println("\nElija su tirada " + jugadores.get(i).getNombre() + ": " + "\n");
                    try {
                        diana.getJugadas().get(sc.nextInt() - 1).intentoDisparo(jugadores.get(i));
                    }catch(TiroFallidoException ignored){
                        System.out.println("Ha fallado la jugada TIROFALLIDOEXCEPTION");
                    }
                    System.out.println("Tiro realizado!! Tiros restantes: " + (TIROS - k));
                }
            }
        }
    }

    public static String podium(){
        List<Jugador> ordenados = new ArrayList<>();
        List<Jugador> aux = jugadores;
        int mayorPuntuacion = 0;
        int indice = 0;
        for(int j = 0; j < 3; j++) {
            for (int i = 0; i < aux.size(); i++) {
                if (aux.get(i).getPuntuacion() > mayorPuntuacion) {
                    mayorPuntuacion = aux.get(i).getPuntuacion();
                    indice = i;
                }
            }
            ordenados.add(aux.get(indice));
            aux.remove(aux.get(indice));
            mayorPuntuacion = 0;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("-----PODIO-----");
        for(int i = 0; i < ordenados.size(); i++){
            sb.append("\n").append("En la posicion ").append(i+1).append(" el jugador ")
                    .append(ordenados.get(i).getNombre())
                    .append(" con ").append(ordenados.get(i)
                    .getPuntuacion()).append(" puntos").append("\n");
        }
        return sb.toString();
    }

    private static Properties getPropiedades() {
        if (propiedades == null) {
            propiedades = new Properties();

            try {

                File file = new File("./src/examenes/examen10032022/diana.properties");
                System.out.println("Fichero encontrado: " + file.exists());
                propiedades.load(new FileReader(file));

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return propiedades;
    }
}
