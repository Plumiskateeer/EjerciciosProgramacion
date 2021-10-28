package capitulo05.bloque05.Ejercicio02_Supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Cola {
    private List<Character> clientes;
    private Semaphore mutex = new Semaphore(1);
    private Semaphore productor = new Semaphore(10);
    private Semaphore consumidor = new Semaphore(3);
    private boolean leyendo = false;
    private StringBuilder sb;

    public Cola() {
        this.clientes = new ArrayList<>();
        sb = new StringBuilder();
    }

    public void anadirCliente() throws InterruptedException {
        while (leyendo){
            Thread.yield();
        }
        consumidor.acquire();
        mutex.acquire();
        clientes.add('*');
        mutex.release();
        productor.release();
    }

    public void atenderCliente() throws InterruptedException {
        while (leyendo){
            Thread.yield();
        }
        productor.acquire();
        mutex.acquire();
        if (clientes.size() > 0)
            clientes.remove(0);
        mutex.release();
        consumidor.release();
    }

    public void imprimirCola() throws InterruptedException {
        leyendo = true;
        mutex.acquire();
        for (Character c : clientes) {
            sb.append(c).append(" ");
        }
        sb.append(" || COLA").append("\n");
        System.out.println(sb);
        sb = new StringBuilder();
        mutex.release();
        leyendo = false;
    }
}
