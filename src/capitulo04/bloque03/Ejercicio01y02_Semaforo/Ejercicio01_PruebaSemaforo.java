package capitulo04.bloque03.Ejercicio01y02_Semaforo;

public class Ejercicio01_PruebaSemaforo {
    public static void main(String[] args) {

        Semaforo s1 = new Semaforo();
        Semaforo s2 = new Semaforo();

        s1.setEstado("AMBAR");
        s2.setEstado("VERDE");

        System.out.println("El semaforo s1 esta en " + s1.getEstado());
        System.out.println("El semaforo s2 esta en " + s2.getEstado());

    }
}


