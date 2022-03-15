package examenes.examen15032022;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Caja {
    private HashMap<Integer,Articulo> articulos;
    private float totalAPagar;

    private static Caja caja = null;

    public static Caja getCaja(){
        if(caja == null){
            caja = new Caja();
        }
        return caja;
    }

    public Caja(){
        this.articulos = new HashMap<>();
        this.totalAPagar = 0;
    }

    public void clienteEnCaja(Cliente cl){
        // añadimos los articulos a la caja
        for(int i = 0; i< cl.getCompra().size(); i++){
            articulos.put(cl.getCompra().get(i).getId(), cl.getCompra().get(i));
        }
        cl.getCompra().clear();
    }

    public float calculaTotal(){
        totalAPagar = 0;
        for(Map.Entry<Integer, Articulo> entry : articulos.entrySet()){
            totalAPagar+= (entry.getValue().getPrecioUnidad() * entry.getValue().getUnidades());
        }
        return totalAPagar;
    }

    public void eliminarArticulo(){
        Scanner sc = new Scanner(System.in);
        int indice = 1;
        while(indice!=0) {
            System.out.println("Articulos en CAJA: ");
            for(Map.Entry<Integer, Articulo> entry : articulos.entrySet()){
                System.out.println("Articulo " + entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("Cual quiere eliminar?: (0 -> No eliminar ninguno)");
            indice = sc.nextInt();
            if (indice != 0) {
                articulos.remove(indice);
                System.out.println("Articulo eliminado de la caja");
            }
        }
    }

    public void pagarCompra() throws DineroInsuficienteException {
        System.out.println("La cantidad a abonar es de: " + calculaTotal());
        System.out.println("Introduzca el dinero a cobrar: ");
        Scanner sc = new Scanner(System.in);
        float dinero = Float.parseFloat(sc.next());
        if (dinero>=calculaTotal()){
            System.out.println("Pago realizado, su cambio es de: " +(dinero-calculaTotal()));
        }else{
            throw new DineroInsuficienteException("El dinero es insuficiente");
        }
    }

    public HashMap<Integer,Articulo> getArticulos(){
        return this.articulos;
    }

    public void setArticulos(HashMap<Integer,Articulo> articulos){
        this.articulos = articulos;
    }

}
