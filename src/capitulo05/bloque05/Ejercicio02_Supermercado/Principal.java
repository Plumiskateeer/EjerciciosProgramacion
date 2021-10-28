package capitulo05.bloque05.Ejercicio02_Supermercado;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Cola c = new Cola();
        AnadirCliente anc = new AnadirCliente(c);
        AtenderCliente atc = new AtenderCliente(c);
        ImprimirCola imp = new ImprimirCola(c);

        anc.start();
        atc.start();
        imp.start();
        anc.join();
        atc.join();
        imp.join();
    }
}
