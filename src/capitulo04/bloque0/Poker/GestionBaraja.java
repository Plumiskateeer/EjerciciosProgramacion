package capitulo04.bloque0.Poker;

public class GestionBaraja {
    public static void main(String[]args){
        Baraja b1 = new Baraja();

        System.out.println(b1);
        b1.cartaDeAbajoArriba();
        System.out.println(b1);
        b1.cartaDeArribaAbajo();
        System.out.println(b1);

    }
}
