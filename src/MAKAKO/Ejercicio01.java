package MAKAKO;

public class Ejercicio01 {

    public static void main(String[]args){
        System.out.println("El numero pi es: " + calcularPi());
    }

    public static double calcularPi(){
        double res = 3, calculo = 0;

        for(int i = 1; i < 100; i++) {
            calculo = (double) 4 / ((2*i) * (2*i + 1) * (2*i + 2));
            if(i%2==0) calculo*=-1;
            res+=calculo;
        }
        return res;
    }

}
