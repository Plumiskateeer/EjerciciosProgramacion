package capitulo07.gestionVentaCoches;

import capitulo07.gestionVentaCoches.modelo.Concesionario;
import capitulo07.gestionVentaCoches.modelo.controladores.ControladorConcesionario;
import capitulo07.gestionVentaCoches.modelo.controladores.ErrorBBDDException;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class GestionConcesionario {

    /**
     *
     */
    public static void menuGestion() {

        int opcionElegida = -1;
        do {
            try {
                System.out.println("\n\t\t\tGESTION DE CONCESIONARIO");

                System.out.println("\n\t1.- Listado de concesionarios.");
                System.out.println("\t2.- Alta de concesionario.");
                System.out.println("\t3.- Modificacion de concesionario.");
                System.out.println("\t4.- Eliminar concesionario.");
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
        List<Concesionario> concesionarios = ControladorConcesionario.getAll();
        System.out.println("\n\tListado de ventas: \n");
        for (Concesionario c : concesionarios) {
            System.out.println("\t" + c.toString());
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
        System.out.println("\n\tAlta de concesionario\n");

        Scanner sc = new Scanner(System.in);
        Concesionario c = new Concesionario();

        System.out.print("\nIntroduzca 'CIF' del concesionario: ");
        c.setCif(sc.nextLine());

        System.out.print("\nIntroduzca 'Nombre' del concesionario: ");
        c.setNombre(sc.nextLine());

        System.out.print("\nIntroduzca 'localidad' del concesionario: ");
        c.setLocalidad(sc.nextLine());

        ControladorConcesionario.almacenar(c);

        System.out.println("\n\tInsertado correctamente!. Pulse 'Intro' para continuar");
        Utils.pausa();
    }


    /**
     * @throws ErrorBBDDException
     */
    private static void modificacion() throws ErrorBBDDException, ParseException {
        System.out.println("\n\tModificacion de concesionario\n");

        Concesionario c = seleccionPorUsuario();

        if (c != null) {
            System.out.print("\nIntroduzca 'CIF' del concesionario ('Intro' para no modificar): ");
            String str = Utils.getStringConsola();
            if (!str.equals(""))
                c.setCif(str);
            System.out.print("\nIntroduzca 'Nombre' del concesionario  ('Intro' para no modificar): ");
            str = Utils.getStringConsola();
            if (!str.equals(""))
                c.setNombre(str);
            System.out.print("\nIntroduzca 'Localidad' del concesionario  ('Intro' para no modificar): ");
            str = Utils.getStringConsola();
            if (!str.equals(""))
                c.setNombre(str);

            ControladorConcesionario.almacenar(c);

            System.out.println("\n\tModificado correctamente!. Pulse 'Intro' para continuar");
            Utils.pausa();
        }
    }


    /**
     * @throws ErrorBBDDException
     */
    private static void baja() throws ErrorBBDDException {
        System.out.println("\n\tModificacion de concesionario\n");

        Concesionario c = seleccionPorUsuario();

        if (c != null) {
            System.out.print("\n�Realmente desea eliminar el registro? (S/N): ");
            String str = Utils.getStringConsola();
            if (str.equalsIgnoreCase("S")) {
                try {
                    ControladorConcesionario.eliminar(c);
                    System.out.println("\n\tEliminado correctamente!. Pulse 'Intro' para continuar");
                    Utils.pausa();
                } catch (ErrorBBDDException e) {
                    System.out.println("ERROR, EXISTEN CLAVES FORANEAS");
                }

            }
        }
    }


    /**
     * @return
     * @throws ErrorBBDDException
     */
    private static Concesionario seleccionPorUsuario() throws ErrorBBDDException {
        Concesionario c = null;
        int id = -2;
        do {
            System.out.println("\n\tIntroduzca ID del concesionario ('-1' - ver listado, '0' - salir): ");
            id = Utils.getIntConsola(-1);
            if (id == -1) {
                listado(false);
            } else {
                if (id != 0) {
                    c = ControladorConcesionario.get(id);
                    if (c == null) {
                        System.out.println("\tError. Ha especificado un ID inv�lido.");
                    }
                }
            }
        } while (c == null && id != 0);
        return c;
    }
}
