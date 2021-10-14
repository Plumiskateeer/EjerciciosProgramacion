package capitulo04.bloque03.Ejercicio03y04y05_PersonaBanco;

public class Ejercicio04_PruebaCuenta {
    public static void main(String[] args) {
        Cuenta cb1 = new Cuenta(50643228, "Pepe", "Jimenez","Plaza mercado", 125478, 0);
        Cuenta cb2 = new Cuenta(42587485, "Manuel", "Lopez","Plaza becquer", 124536,1500);

        System.out.println(cb1);
        System.out.println(cb2);
        cb2.transferirDinero(500, cb1);
        System.out.println(cb1);
        System.out.println(cb2);
        cb1.transferirDinero(15500, cb2);

    }
}
