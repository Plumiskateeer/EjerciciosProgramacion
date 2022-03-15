package examenes.examen15032022;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Principal {
    private static Properties propiedades = null;

    public static void main(String[]args) throws DineroInsuficienteException {
        System.out.println(getPropiedades().getProperty("SUPERMERCADO"));

        Cliente cl = new Cliente("Juan Alberto");

        Pasta p1 = new Pasta(1,4,"pasta blanca",1.5f,"spaguettis");
        Ropa r1 = new Ropa(2,6,"camisetas",6f,"m");
        Electronica el1 = new Electronica(3,2,"pilas",1.5f,5);
        Fruta f1 = new Fruta(4,2,"melones",.75f,true);

        cl.getCompra().add(p1);
        cl.getCompra().add(r1);
        cl.getCompra().add(el1);
        cl.getCompra().add(f1);

        Caja.getCaja().clienteEnCaja(cl);
        Caja.getCaja().eliminarArticulo();
        Caja.getCaja().pagarCompra();
    }


    private static Properties getPropiedades() {
        if (propiedades == null) {
            propiedades = new Properties();

            try {

                File file = new File("./src/examenes/examen15032022/caja.properties");
                propiedades.load(new FileReader(file));

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return propiedades;
    }
}
