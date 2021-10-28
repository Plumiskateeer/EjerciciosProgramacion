package capitulo05.bloque05.Supermercado;

public class AnadirCliente extends Thread{
    private Cola c;
    private int numAnadidos = 0;

    public AnadirCliente(Cola c){
        this.c = c;
    }

    @Override
    public void run() {
        while(true){
            try {
                numAnadidos++;
                c.anadirCliente();
                if (numAnadidos>10) {
                    c.imprimirCola();
                    System.out.println(c.getSb());
                    c.resetImprimirCola();
                    numAnadidos = 0;
                }
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
