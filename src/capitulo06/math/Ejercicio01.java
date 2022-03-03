package capitulo06.math;

public class Ejercicio01 {
    public static void main(String[]args) {
        double r1 = 0, r2 = 0, x = 0;

        do {
            x += 0.0001;
            r1 = Math.sqrt(x);
            r2 = (-Math.log(x));
        } while (Math.abs(r1-r2) > 0.0001);
        System.out.println("Se cortan en: " + r1 + " " + r2);
    }
}
