package capitulo04.SimulacroExamenSpaceInvaders;

public class CampoBatalla {
    private Personaje[] humanos = new Humano[20];
    private Personaje[] malvados = new Malvado[20];

    private static CampoBatalla instance = null;

    public static CampoBatalla getInstance() {
        if(instance==null)
            instance = new CampoBatalla();
        return instance;
    }

    private CampoBatalla() {
        inicializarPersonajes(humanos);
        inicializarPersonajes(malvados);
    }

    public void inicializarPersonajes(Personaje[] personajes) {
        int cont=0,vida = 0;
        for(Personaje p : personajes){
            vida = (int) Math.round(Math.random()*50)+50;
            if(p instanceof Humano){
                p = new Humano(vida,"h" + cont, true);
            }else{
                p = new Malvado(vida,"m" + cont, true);
            }
            cont++;
        }
        if(personajes[personajes.length-1] instanceof Humano){
            Humano h = (Humano) personajes[personajes.length-1];
            h.setPuntosVida(h.getPuntosVida()*2);
        }else if(personajes[personajes.length-1] instanceof Malvado){
            Malvado m = (Malvado) personajes[personajes.length-1];
            m.setPuntosVida(m.getPuntosVida()*2);
        }
    }

    public Personaje[] mezclarPersonajes(Personaje[] personajes) {
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
    private void pelea(Personaje[] humanos, Personaje[] malvados){
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

    private Personaje getPrimerPersonajeVivo(Personaje[] personajes){
        boolean tengoVivo = false;
        Personaje vivo = null;
        for (int i = 0; i < personajes.length && !tengoVivo; i++){
            if(personajes[i].isVivo()){
                tengoVivo = true;
                vivo = personajes[i];
            }
        }
        return vivo;
    }

    // Gs  Ss
    public Personaje[] getHumanos() {
        return humanos;
    }

    public void setHumanos(Personaje[] humanos) {
        this.humanos = humanos;
    }

    public Personaje[] getMalvados() {
        return malvados;
    }

    public void setMalvados(Personaje[] malvados) {
        this.malvados = malvados;
    }
}
