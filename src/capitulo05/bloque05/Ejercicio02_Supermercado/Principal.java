package capitulo05.bloque05.Ejercicio02_Supermercado;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        // He adaptado este ejercicio porque empece a hacerlo con arrays y me quedo de una manera muy rara,
        // he realizado una cola que va atendiendo y recibiendo clientes hasta el infinito, usando Threads concurrentes
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
