package capitulo04.bloque0.batalla;

public class Batalla {
    public static void main(String[] args) {
        NaveAlienigena naveAl = new NaveAlienigena(10);
        NaveHumana naveHum = new NaveHumana(10);
        System.out.println(naveAl);
        System.out.println(naveHum);
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }

    public static void comienzaBatalla(NaveHumana nHum, NaveAlienigena nAli){

    }
}
