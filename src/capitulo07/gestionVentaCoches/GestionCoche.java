package capitulo07.gestionVentaCoches;


import capitulo07.gestionVentaCoches.modelo.Coche;
import capitulo07.gestionVentaCoches.modelo.Fabricante;
import capitulo07.gestionVentaCoches.modelo.controladores.ControladorCliente;
import capitulo07.gestionVentaCoches.modelo.controladores.ControladorCoche;
import capitulo07.gestionVentaCoches.modelo.controladores.ControladorFabricante;
import capitulo07.gestionVentaCoches.modelo.controladores.ErrorBBDDException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class GestionCoche {

    /**
     *
     */
    public static void menuGestion() {

        int opcionElegida = -1;
        do {
            try {
                System.out.println("\n\t\t\tGESTION DE COCHES");

                System.out.println("\n\t1.- Listado de coches.");
                System.out.println("\t2.- Alta de coche.");
                System.out.println("\t3.- Modificacion de coche.");
                System.out.println("\t4.- Baja de coche.");
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
            } catch (ErrorBBDDException e) {
                System.out.println("\n\t\t\tError de acceso a datos: " + e.getMessage() + "\n");
                e.printStackTrace();
            }
        } while (opcionElegida != 0);
    }


    /**
     * @throws ErrorBBDDException
     */
    private static void listado(boolean pausafinal) throws ErrorBBDDException {
        List<Coche> coches = ControladorCoche.getAll();
        System.out.println("\n\tListado de fabricantes: \n");
        for (Coche c : coches) {
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
    private static void alta() throws ErrorBBDDException {
        System.out.println("\n\tAlta de coche\n");

        Scanner sc = new Scanner(System.in);
        Coche c = new Coche();
        System.out.print("\nIntroduzca 'ID' del fabricante: (EL ID DEBE EXISTIR EN LA BASE DE DATOS) ");
        c.setIdfabricante(sc.nextInt());
        System.out.print("\nIntroduzca 'Numero' del bastidor: ");
        c.setBastidor(sc.next());
        System.out.print("\nIntroduzca 'Modelo' del coche: ");
        c.setModelo(sc.next());
        System.out.print("\nIntroduzca 'Color' del coche: ");
        c.setColor(sc.next());

        ControladorCoche.almacenar(c);

        System.out.println("\n\tInsertado correctamente!. Pulse 'Intro' para continuar");
        Utils.pausa();
    }


    /**
     * @throws ErrorBBDDException
     */
    private static void modificacion() throws ErrorBBDDException {
        System.out.println("\n\tModificaci�n de coche\n");

        Coche c = seleccionPorUsuario();

        if (c != null) {
            System.out.print("\nIntroduzca 'id' del fabricante del coche('Intro' para no modificar):  (EL ID DEBE EXISTIR EN LA BASE DE DATOS) ");
            String str = Utils.getStringConsola();
            if (!str.equals(""))
                c.setId(Integer.parseInt(str));

            System.out.print("\nIntroduzca 'Numero' del bastidor del coche ('Intro' para no modificar): ");
            str = Utils.getStringConsola();
            if (!str.equals(""))
                c.setBastidor(str);

            System.out.print("\nIntroduzca 'modelo' del coche  ('Intro' para no modificar): ");
            str = Utils.getStringConsola();
            if (!str.equals(""))
                c.setModelo(str);

            System.out.print("\nIntroduzca 'Color' del coche  ('Intro' para no modificar): ");
            str = Utils.getStringConsola();
            if (!str.equals(""))
                c.setColor(str);

            ControladorCoche.almacenar(c);

            System.out.println("\n\tModificado correctamente!. Pulse 'Intro' para continuar");
            Utils.pausa();
        }
    }


    /**
     * @throws ErrorBBDDException
     */
    private static void baja() throws ErrorBBDDException {
        System.out.println("\n\tModificaci�n de coche\n");

        Coche c = seleccionPorUsuario();

        if (c != null) {
            System.out.print("\n�Realmente desea eliminar el registro? (S/N): ");
            String str = Utils.getStringConsola();
            if (str.equalsIgnoreCase("S")) {
                ControladorCoche.eliminar(c);
                System.out.println("\n\tEliminado correctamente!. Pulse 'Intro' para continuar");
                Utils.pausa();
            }
        }
    }


    /**
     * @return
     * @throws ErrorBBDDException
     */
    private static Coche seleccionPorUsuario() throws ErrorBBDDException {
        Coche c = null;
        int id = -2;
        do {
            System.out.println("\n\tIntroduzca ID del coche ('-1' - ver listado, '0' - salir): ");
            id = Utils.getIntConsola(-1);
            if (id == -1) {
                listado(false);
            } else {
                if (id != 0) {
                    c = ControladorCoche.get(id);
                    if (c == null) {
                        System.out.println("\tError. Ha especificado un ID inv�lido.");
                    }
                }
            }
        } while (c == null && id != 0);
        return c;
    }
}
