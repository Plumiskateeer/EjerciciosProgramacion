package examenes.examen18022022;

import capitulo06.wrappers.Propiedades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Ejercicio04_Propiedades {
    private static Properties propiedades = null;

    public Ejercicio04_Propiedades() {
        super();
    }

    /**
     *
     * @return
     */
    private static Properties getPropiedades() {
        if (propiedades == null) {
            propiedades = new Properties();

            try {

                // Otra forma de leer el fichero de propiedades
                File file = new File("./src/capitulo06/wrappers/ejemplo.properties");
                System.out.println("Fichero encontrado: " + file.exists());
                propiedades.load(new FileReader(file));

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return propiedades;
    }

    /**
     *
     * @param nombrePropiedad
     * @return
     */
    public static String getProperty(String nombrePropiedad) {
        return getPropiedades().getProperty(nombrePropiedad);
    }


    /**
     *
     * @param nombrePropiedad
     * @return
     */
    public static int getIntProperty (String nombrePropiedad) {
        return Integer.parseInt(getPropiedades().getProperty(nombrePropiedad));
    }


    /**
     *
     * @param nombrePropiedad
     * @return
     */
    public static Float getFloatProperty (String nombrePropiedad) {
        return Float.parseFloat(getPropiedades().getProperty(nombrePropiedad));
    }

    /**
     *
     * @param nombrePropiedad
     * @return
     */
    public static Boolean getBooleanProperty (String nombrePropiedad) {
        return Boolean.parseBoolean(getPropiedades().getProperty(nombrePropiedad));
    }



    /**
     *
     * @param args
     */
    public static void main (String args[]) {
        String usuario = Propiedades.getProperty("USUARIO");
        Float password = Propiedades.getFloatProperty("PASSWORD");
        int id = Propiedades.getIntProperty("ID_USUARIO");
        boolean activo = Propiedades.getBooleanProperty("VIVO");

        System.out.println("Usuario leído del fichero de propiedades: " + usuario);
        System.out.println("Password leído del fichero de propiedades: " + password);
        System.out.println("Id de usuario leído del fichero de propiedades: " + id);
        System.out.println("Estado de usuario " + activo);

    }
}
