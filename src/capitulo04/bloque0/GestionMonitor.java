package capitulo04.bloque0;

public class GestionMonitor {
    public static void main(String[] args) {
        Monitor m1 = new Monitor();
        Monitor m2 = new Monitor(22, 13, "hd", "muchos", 543);

        System.out.println(m1);
        System.out.println(m2);
    }
}
