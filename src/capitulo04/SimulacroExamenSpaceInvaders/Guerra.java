package capitulo04.SimulacroExamenSpaceInvaders;

public class Guerra {
    public static void main(String[]args){
        CampoBatalla.getInstance().mezclarPersonajes(CampoBatalla.getInstance().getHumanos());
        CampoBatalla.getInstance().mezclarPersonajes(CampoBatalla.getInstance().getMalvados());
    }
}
