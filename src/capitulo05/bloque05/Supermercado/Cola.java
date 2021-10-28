package capitulo05.bloque05.Supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Cola {
    private List<Character> clientes;
    private Semaphore mutex = new Semaphore(1);
    private Semaphore productor = new Semaphore(10);
    private Semaphore consumidor = new Semaphore(3);
    private Semaphore imprimir = new Semaphore(1);
    private StringBuilder sb;

    public Cola(){
        this.clientes = new ArrayList<>();
        sb = new StringBuilder();
    }

    public StringBuilder getSb(){
        return this.sb;
    }

    public void anadirCliente() throws InterruptedException {
        productor.acquire();
        mutex.acquire();
        if(clientes.size()<10)
            clientes.add('*');
        mutex.release();
        productor.release();
    }

    public void atenderCliente() throws InterruptedException {
        consumidor.acquire();
        mutex.acquire();
        if(clientes.size()>0)
            clientes.remove(0);
        mutex.release();
        consumidor.release();
    }
    public void imprimirCola() throws InterruptedException {
        consumidor.acquire();
        productor.acquire();
        mutex.acquire();
        imprimir.acquire();

        sb = new StringBuilder();
        for(Character c : clientes){
            sb.append(c).append(" ");
        }
        sb.append(" || COLA").append("\n");

        imprimir.release();
        mutex.release();
        productor.release();
        consumidor.release();
    }
    public void resetImprimirCola() throws InterruptedException {
        consumidor.acquire();
        productor.acquire();
        mutex.acquire();
        imprimir.acquire();

        sb = new StringBuilder();

        imprimir.release();
        mutex.release();
        productor.release();
        consumidor.release();

    }
}
