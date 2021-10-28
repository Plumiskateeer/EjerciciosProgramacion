package capitulo05.bloque05.Ejercicio02_Supermercado;

public class ImprimirCola extends Thread {
    private Cola c;

    public ImprimirCola(Cola c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            try {
                c.imprimirCola();
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
