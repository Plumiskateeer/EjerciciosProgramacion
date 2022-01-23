package capitulo04.SimulacroExamenSpaceInvaders;

public class CampoBatalla {
    private Personaje[] humanos = new Humano[20];
    private Personaje[] malvados = new Malvado[20];

    private static CampoBatalla instance = new CampoBatalla();

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
        int cont=0,vida;
        for(int i = 0; i < personajes.length; i++){
            vida = (int) Math.round(Math.random()*50)+50;
            if(personajes instanceof Humano[]){
                personajes[i] = new Humano(vida,"h" + cont, true);
            }else if(personajes instanceof Malvado[]){
                personajes[i] = new Malvado(vida,"m" + cont, true);
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

    public void mezclarPersonajes(Personaje[] personajes) {
        Personaje[] nuevo = null;
        if (personajes instanceof Humano []) {
            nuevo = new Humano[personajes.length];
        }else if(personajes instanceof Malvado []){
            nuevo = new Malvado[personajes.length];
        }
        for (int i = 0; i < nuevo.length; i++) {
            int pos = (int) Math.round(Math.random() * (nuevo.length - 1));
            if (nuevo[pos] == null) {
                nuevo[pos] = personajes[i];
            } else i--;
        }
        for (int i = 0; i < personajes.length; i++) {
            personajes[i] = nuevo[i];
        }
    }

    public void pelea(){
        while(estanVivos(humanos) && estanVivos(malvados)) {
            Personaje humanoVivo = getPrimerPersonajeVivo(humanos); // consigo el primer humano vivo
            Personaje malvadoVivo = getPrimerPersonajeVivo(malvados); // consigo el primer malvado vivo
            if (humanoVivo!=null){                              // si he conseguido un humano vivo
                System.out.print(humanoVivo.getNombre()+" dispara a " + malvadoVivo.getNombre() + "\n");
                    leDisparo(malvadoVivo);                             // disparo al malvado vivo
                if (malvadoVivo.isVivo()){                          // si sigue vivo tras el disparo
                    malvadoVivo.sumarDisparo();                         // le apunto un disparo recibido
                    System.out.print(malvadoVivo.getNombre()+" dispara a " + humanoVivo.getNombre() + "\n");
                    leDisparo(humanoVivo);                              // le dispara al humano que le ha disparado
                    if (humanoVivo.isVivo()){                           // si sigue vivo
                        humanoVivo.sumarDisparo();                          // se suma un tanto
                    }else {
                        humanoVivo.setVivo(false);                    // si no, el humano ha muerto
                        if (getPrimerPersonajeVivo(humanos)==null) System.out.println("                               ¡¡¡¡¡¡¡¡¡ LOS HUMANOS HAN MUERTO !!!!!!");
                        // si por algun motivo me da null, los malvados han muerto
                    }
                }else{
                    malvadoVivo.setVivo(false);
                    if (getPrimerPersonajeVivo(malvados)==null) System.out.println("                                  ¡¡¡¡¡¡¡¡¡ LOS MALVADOS HAN MUERTO !!!!!!");
                    // si por algun motivo me da null, los malvados han muerto// si no, el malvado ha muerto
                }
            }

            System.out.println(humanoVivo);
            System.out.println(malvadoVivo + "\n");

        }
        System.out.println(mostrarEstadisticas());
    }

    private void leDisparo(Personaje recibe) {
        if (recibe.isVivo()){
            int restar = (int) Math.round(Math.random() * 20) + 5;
            recibe.setPuntosVida(recibe.getPuntosVida() - restar);
        }
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
    private boolean estanVivos(Personaje[] personajes){
        boolean tengoVivo = false;
        for (int i = 0; i < personajes.length && !tengoVivo; i++){
            if(personajes[i].isVivo()){
                tengoVivo = true;
            }
        }
        return tengoVivo;
    }

    private String mostrarEstadisticas() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n---DISPAROS RECIBIDOS---\n");
        sb.append("       HUMANOS\n");
        sb.append(imprimirTirosPersonaje(humanos));
        sb.append("\n").append(soldadoMasDuro(humanos)).append("\n");
        sb.append("\n       MALVADOS\n");
        sb.append(imprimirTirosPersonaje(malvados));
        sb.append("\n").append(soldadoMasDuro(malvados)).append("\n");
        return sb.toString();
    }

    private String soldadoMasDuro(Personaje[] personajes) {
        int tiros = 0;
        String nombre = "NO ENCONTRADO";
        for (Personaje p : personajes){
            if (p.getTirosRecibidos() > tiros && !p.isVivo()) {
                tiros = p.getTirosRecibidos();
                nombre = p.getNombre();
            }
        }
        return "El soldado mas duro fue " + nombre + " con " + tiros + " recibidos antes de morir";
    }

    private String imprimirTirosPersonaje(Personaje[] personajes){
        StringBuilder sb = new StringBuilder();
        for (Personaje p : personajes){
            sb.append("________");
        }
        sb.append("\n");
        sb.append("TIROS |");
        for(Personaje p : personajes){
            sb.append(p.getNombre() + ": " + p.getTirosRecibidos() + " |");
        }
        sb.append("\n");
        for (Personaje p : personajes){
            sb.append("¨¨¨¨¨¨¨¨");
        }
        return sb.toString();
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

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Personaje h : humanos){
            sb.append(h);
        }
        sb.append("\n");
        for(Personaje m : malvados){
            sb.append(m);
        }
        return sb.toString();
    }
}
