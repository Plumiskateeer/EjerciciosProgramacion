package capitulo04.bloque0.batalla;

import java.util.Arrays;

public class CampoBatalla {
    private Humano[] humanos = new Humano[5];
    private Alien[] aliens = new Alien[5];

    public CampoBatalla() {
        inicializarPersonajes(humanos);
        inicializarPersonajes(aliens);
    }

    public static void inicializarPersonajes(Personaje[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array instanceof Alien[])
                array[i] = new Alien();
            else array[i] = new Humano();
        }
        Personaje ultimo = array[array.length - 1];
        ultimo.setPorcentajeAcierto(60);
        ultimo.setPuntosFuerza(100);
        ultimo.setPuntosVida(1000);
    }

    public void iniciarBatalla() {
        Alien primerAlienVivo = (Alien) localizarPrimerPersonajeVivo(aliens);
        Humano primerHumanoVivo = (Humano) localizarPrimerPersonajeVivo(humanos);

        do {
            //dispara alien a humano
            primerAlienVivo = (Alien) localizarPrimerPersonajeVivo(aliens);
            primerHumanoVivo = (Humano) localizarPrimerPersonajeVivo(humanos);
            disparaSobrePersonaje(primerAlienVivo, primerHumanoVivo);

            //dispara humano a alien
            primerHumanoVivo = (Humano) localizarPrimerPersonajeVivo(humanos);
            if (primerHumanoVivo == null)
                System.out.println("Han ganado los aliens");
            else disparaSobrePersonaje(primerHumanoVivo, primerAlienVivo);
            disparaSobrePersonaje(primerHumanoVivo, primerAlienVivo);

            //compruebo bandos
            primerAlienVivo = (Alien) localizarPrimerPersonajeVivo(aliens);

            if (primerAlienVivo == null)
                System.out.println("Han ganado los humanos");

            muestraCampoBatalla();
        }while(localizarPrimerPersonajeVivo(aliens) != null && localizarPrimerPersonajeVivo(humanos) != null);
    }

    public void disparaSobrePersonaje(Personaje dispara, Personaje recibe) {
        int probabilidad = (int) Math.round(Math.random() * 100);

        if (dispara != null && probabilidad <= dispara.getPorcentajeAcierto()) {
            recibe.setPuntosVida(recibe.getPuntosVida() - recibe.getPuntosFuerza());

            // si tiene menos de 0 puntos de vida se queda con 0, si no con la vida que tenia
            recibe.setPuntosVida(Math.max(recibe.getPuntosVida(), 0));
        }
        //despues muestro el campo de batalla


    }

    public void muestraCampoBatalla(){
        System.out.print("Aliens: ");
        for(Alien a : aliens){
            System.out.print(a.toString());
        }
        System.out.print("\nHumanos: ");
        for(Humano h : humanos){
            System.out.print(h.toString());
        }
        System.out.println("\n");
    }

    public static Personaje localizarPrimerPersonajeVivo(Personaje[] array) {
        for (Personaje o : array)
            if (o.getPuntosVida() > 0)
                return o;
        return null;
    }

    public Humano[] getHumanos() {
        return humanos;
    }

    public void setHumanos(Humano[] humanos) {
        this.humanos = humanos;
    }

    public Alien[] getAliens() {
        return aliens;
    }

    public void setAliens(Alien[] aliens) {
        this.aliens = aliens;
    }

    @Override
    public String toString() {
        return "CampoBatalla{" +
               "humanos=" + Arrays.toString(humanos) +
               ", aliens=" + Arrays.toString(aliens) +
               '}';
    }
}
