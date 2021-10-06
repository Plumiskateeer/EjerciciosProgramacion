package capitulo04.bloque03.banco;

import capitulo04.bloque03.banco.Cuenta;

public class Ejercicio04_PruebaCuenta {
    public static void main(String[]args){
        Cuenta cb1 = new Cuenta(50643228,"Pepe","Jimenez",0);
        Cuenta cb2 = new Cuenta(42587485,"Manuel","Lopez",1500);

        System.out.println(cb1);
        System.out.println(cb2);
        cb2.transferirDinero(500,cb1);
        System.out.println(cb1);
        System.out.println(cb2);
        cb1.transferirDinero(15500,cb2);

    }
}
