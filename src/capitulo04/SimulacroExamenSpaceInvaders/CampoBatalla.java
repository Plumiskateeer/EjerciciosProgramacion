package capitulo04.SimulacroExamenSpaceInvaders;

public class CampoBatalla {
    private Personaje[] humanos = new Humano[20];
    private Personaje[] malvados = new Malvado[20];

    private static CampoBatalla campo = new CampoBatalla();

    public static CampoBatalla getInstance() {
        return campo;
    }

    private CampoBatalla() {
        inicializarPersonajes(humanos);
        inicializarPersonajes(malvados);
    }

    public static void main(String[]args){

    }

    public void inicializarPersonajes(Personaje[] personajes) {
        int cont=0;
        for(Personaje p : personajes){
            int vida = (int) Math.round(Math.random()*50)+50;
            if(personajes instanceof Humano[]){
                p = new Humano(vida,"h" + cont, true);
            }else{
                p = new Malvado(vida,"m" + cont, true);
            }
        }
        personajes[personajes.length-1].setPuntosVida(personajes[personajes.length-1].getPuntosVida()*2);

    }

    public Personaje[] mezclarPersonajes(Personaje[] personajes){
        Personaje[] nuevo = new Personaje[personajes.length];
        for (int i = 0; i < nuevo.length; i++) {
            int pos = (int) Math.round(Math.random() * (nuevo.length - 1));
            if (nuevo[pos] == null) {
                nuevo[pos] = personajes[i];
            } else i--;
        }
        return nuevo;
    }

    // ESTE METODO ESTA INCOMPLETO
    public void pelea(Personaje[] humanos, Personaje[] malvados){
        int contHumanos = 0;
        int contMalvados = 0;
        while(humanos[humanos.length-1].isVivo() && malvados[malvados.length-1].isVivo()) {
            Personaje p = humanos[contHumanos++];
            if (p instanceof Humano && p.isVivo()) {
                leDisparo(p);
            }
        }
    }

    private void leDisparo(Personaje personaje) {
        int restar = (int) Math.round(Math.random()*20)+5;
        personaje.setPuntosVida(personaje.getPuntosVida()-restar);
    }
}
