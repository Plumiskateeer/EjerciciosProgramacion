package capitulo05.bloque05.Supermercado;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Cola c = new Cola();
        AnadirCliente anc = new AnadirCliente(c);
        AtenderCliente atc = new AtenderCliente(c);

        anc.start();
        atc.start();
        anc.join();
        atc.join();
    }
}
