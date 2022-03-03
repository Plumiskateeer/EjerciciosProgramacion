package capitulo06.math;

public class Ejercicio02 {
    public static void main(String[] args) {

        double pi = 4;
        double num = 4;
        double den = 3;


        do {
            pi = pi - (num/den);

            num = num * -1;
            den += 2;


        } while (pi <= Math.PI - 0.00001 || pi >= Math.PI);


        System.out.println("El número pi es: " + pi);
    }
}
