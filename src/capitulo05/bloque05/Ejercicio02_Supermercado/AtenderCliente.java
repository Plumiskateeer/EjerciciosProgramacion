package capitulo05.bloque05.Ejercicio02_Supermercado;

public class AtenderCliente extends Thread {
    private Cola c;

    public AtenderCliente(Cola c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            try {
                c.atenderCliente();
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
