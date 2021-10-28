package capitulo05.bloque05.Ejercicio02_Supermercado;

public class AnadirCliente extends Thread {
    private Cola c;

    public AnadirCliente(Cola c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            try {
                c.anadirCliente();
                Thread.sleep(130);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
