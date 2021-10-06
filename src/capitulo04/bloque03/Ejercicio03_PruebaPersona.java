package capitulo04.bloque03;

import capitulo04.bloque03.banco.Persona;

public class Ejercicio03_PruebaPersona {
    public static void main(String[]args){
        Persona p1 = new Persona();
        Persona p2 = new Persona("Antonio", "Lopez" , "La torca" , 50648574, 999887744);

        System.out.println("La primera persona es: ");
        System.out.println(p1);
        System.out.println("La segunda persona es: ");
        System.out.println(p2);
    }
}
