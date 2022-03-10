package capitulo07.gestionVentaCoches;

import capitulo07.gestionVentaCoches.modelo.Venta;
import capitulo07.gestionVentaCoches.modelo.controladores.ControladorVenta;
import capitulo07.gestionVentaCoches.modelo.controladores.ErrorBBDDException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class GestionVenta {

    /**
     *
     */
    public static void menuGestion() {

        int opcionElegida = -1;
        do {
            try {
                System.out.println("\n\t\t\tGESTION DE VENTAS");

                System.out.println("\n\t1.- Listado de ventas.");
                System.out.println("\t2.- Alta de venta.");
                System.out.println("\t3.- Modificacion de venta.");
                System.out.println("\t4.- Eliminar venta.");
                System.out.println("\t0.- Salir");
                System.out.println("\n\tElija una opcion: ");

                opcionElegida = Utils.getIntConsola(0, 4);

                switch (opcionElegida) {
                    case 0:
                        break;
                    case 1:
                        listado(true);
                        break;
                    case 2:
                        alta();
                        break;
                    case 3:
                        modificacion();
                        break;
                    case 4:
                        baja();
                        break;
                }
            } catch (ErrorBBDDException | ParseException e) {
                System.out.println("\n\t\t\tError de acceso a datos: " + e.getMessage() + "\n");
                e.printStackTrace();
            }
        } while (opcionElegida != 0);
    }


    /**
     * @throws ErrorBBDDException
     */

    private static void listado(boolean pausafinal) throws ErrorBBDDException {
        List<Venta> ventas = ControladorVenta.getAll();
        System.out.println("\n\tListado de ventas: \n");
        for (Venta v : ventas) {
            System.out.println("\t" + v.toString());
        }
        if (pausafinal) {
            System.out.println("\n\tPulse 'Intro' tecla para continuar");
            Utils.pausa();
        }
    }


    /**
     * @throws ErrorBBDDException
     */
    private static void alta() throws ErrorBBDDException, ParseException {
        System.out.println("\n\tAlta de venta\n");

        Scanner sc = new Scanner(System.in);
        Venta v = new Venta();

        System.out.print("\nIntroduzca 'ID' del cliente: (EL ID DEBE EXISTIR EN LA BASE DE DATOS) ");
        v.setIdCliente(sc.nextInt());

        System.out.print("\nIntroduzca 'ID' del concesionario: (EL ID DEBE EXISTIR EN LA BASE DE DATOS) ");
        v.setIdConcesionario(sc.nextInt());

        System.out.print("\nIntroduzca 'ID' del coche: (EL ID DEBE EXISTIR EN LA BASE DE DATOS)");
        v.setIdCoche(sc.nextInt());

        System.out.print("\nIntroduzca 'fecha' de la venta: FORMATO YYYY-MM-DD");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        v.setFecha(df.parse(sc.next()));

        System.out.print("\nIntroduzca 'precio' de la venta: ");
        v.setPrecioventa(sc.nextInt());

        ControladorVenta.almacenar(v);

        System.out.println("\n\tInsertado correctamente!. Pulse 'Intro' para continuar");
        Utils.pausa();
    }


    /**
     * @throws ErrorBBDDException
     */
    private static void modificacion() throws ErrorBBDDException, ParseException {
        System.out.println("\n\tModificaci�n de venta\n");

        Venta v = seleccionPorUsuario();

        if (v != null) {
            System.out.print("\nIntroduzca 'ID' del cliente: (EL ID DEBE EXISTIR EN LA BASE DE DATOS) ('Intro' para no modificar) ");
            String str = Utils.getStringConsola();
            if (!str.equals(""))
                v.setIdCliente(Integer.parseInt(str));

            System.out.print("\nIntroduzca 'ID' del concesionario: (EL ID DEBE EXISTIR EN LA BASE DE DATOS) ('Intro' para no modificar)");
            str = Utils.getStringConsola();
            if (!str.equals(""))
                v.setIdConcesionario(Integer.parseInt(str));

            System.out.print("\nIntroduzca 'ID' del coche: (EL ID DEBE EXISTIR EN LA BASE DE DATOS) ('Intro' para no modificar)");
            str = Utils.getStringConsola();
            if (!str.equals(""))
                v.setIdCoche(Integer.parseInt(str));

            System.out.print("\nIntroduzca 'fecha' de la venta: ('Intro' para no modificar) ");
            str = Utils.getStringConsola();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            if (!str.equals(""))
                v.setFecha(df.parse(str));

            ControladorVenta.almacenar(v);

            System.out.println("\n\tModificado correctamente!. Pulse 'Intro' para continuar");
            Utils.pausa();
        }
    }


    /**
     * @throws ErrorBBDDException
     */
    private static void baja() throws ErrorBBDDException {
        System.out.println("\n\tModificaci�n de venta\n");

        Venta v = seleccionPorUsuario();

        if (v != null) {
            System.out.print("\n�Realmente desea eliminar el registro? (S/N): ");
            String str = Utils.getStringConsola();
            if (str.equalsIgnoreCase("S")) {
                ControladorVenta.eliminar(v);
                System.out.println("\n\tEliminado correctamente!. Pulse 'Intro' para continuar");
                Utils.pausa();
            }
        }
    }


    /**
     * @return
     * @throws ErrorBBDDException
     */
    private static Venta seleccionPorUsuario() throws ErrorBBDDException {
        Venta v = null;
        int id = -2;
        do {
            System.out.println("\n\tIntroduzca ID de la venta ('-1' - ver listado, '0' - salir): ");
            id = Utils.getIntConsola(-1);
            if (id == -1) {
                listado(false);
            } else {
                if (id != 0) {
                    v = ControladorVenta.get(id);
                    if (v == null) {
                        System.out.println("\tError. Ha especificado un ID inv�lido.");
                    }
                }
            }
        } while (v == null && id != 0);
        return v;
    }
}