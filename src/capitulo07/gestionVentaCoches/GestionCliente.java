package capitulo07.gestionVentaCoches;

import capitulo07.gestionVentaCoches.modelo.Cliente;
import capitulo07.gestionVentaCoches.modelo.controladores.ControladorCliente;
import capitulo07.gestionVentaCoches.modelo.controladores.ControladorConcesionario;
import capitulo07.gestionVentaCoches.modelo.controladores.ErrorBBDDException;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class GestionCliente {

    /**
     *
     */
    public static void menuGestion() {

        int opcionElegida = -1;
        do {
            try {
                System.out.println("\n\t\t\tGESTION DE CLIENTES");

                System.out.println("\n\t1.- Listado de clientes.");
                System.out.println("\t2.- Alta de cliente.");
                System.out.println("\t3.- Modificacion de cliente.");
                System.out.println("\t4.- Baja de cliente.");
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
        List<Cliente> clientes = ControladorCliente.getAll();
        System.out.println("\n\tListado de clientes: \n");
        for (Cliente cl : clientes) {
            System.out.println("\t" + cl.toString());
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
        System.out.println("\n\tAlta de cliente\n");

        Cliente cl = new Cliente();

        System.out.print("\nIntroduzca 'Nombre' del cliente  ('Intro' para no modificar): ");
        cl.setNombre(Utils.getStringConsola());

        System.out.print("\nIntroduzca 'Apellidos' del cliente  ('Intro' para no modificar): ");
        cl.setApellidos(Utils.getStringConsola());

        System.out.print("\nIntroduzca 'Localidad' del cliente  ('Intro' para no modificar): ");
        cl.setLocalidad(Utils.getStringConsola());

        System.out.print("\nIntroduzca 'Dni' del cliente  ('Intro' para no modificar): ");
        cl.setDniNie(Utils.getStringConsola());

        System.out.print("\nIntroduzca 'FechaNacimiento' del cliente  ('Intro' para no modificar): ");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        cl.setFechaNac(df.parse(Utils.getStringConsola()));

        System.out.print("\nIntroduzca 'Activo' del cliente  (true o false) ('Intro' para no modificar): ");
        String str = Utils.getStringConsola();
        if (str.equals("true"))
            cl.setActivo(true);
        else cl.setActivo(false);

        ControladorCliente.almacenar(cl);

        System.out.println("\n\tInsertado correctamente!. Pulse 'Intro' para continuar");
        Utils.pausa();
    }


    /**
     * @throws ErrorBBDDException
     */
    private static void modificacion() throws ErrorBBDDException, ParseException {
        System.out.println("\n\tModificaci�n de cliente\n");

        Cliente cl = seleccionPorUsuario();

        if (cl != null) {
            System.out.print("\nIntroduzca 'Nombre' del cliente  ('Intro' para no modificar): ");
            String str = Utils.getStringConsola();
            if (!str.equals(""))
                cl.setNombre(str);

            System.out.print("\nIntroduzca 'Apellidos' del cliente  ('Intro' para no modificar): ");
            str = Utils.getStringConsola();
            if (!str.equals(""))
                cl.setApellidos(str);

            System.out.print("\nIntroduzca 'Localidad' del cliente  ('Intro' para no modificar): ");
            str = Utils.getStringConsola();
            if (!str.equals(""))
                cl.setLocalidad(str);

            System.out.print("\nIntroduzca 'Dni' del cliente  ('Intro' para no modificar): ");
            str = Utils.getStringConsola();
            if (!str.equals(""))
                cl.setDniNie(str);

            System.out.print("\nIntroduzca 'FechaNacimiento' del cliente  ('Intro' para no modificar): ");
            str = Utils.getStringConsola();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            if (!str.equals(""))
                cl.setFechaNac(df.parse(str));

            System.out.print("\nIntroduzca 'Activo' del cliente  (true o false) ('Intro' para no modificar): ");
            str = Utils.getStringConsola();
            if (!str.equals("")) {
                if (str.equals("true"))
                    cl.setActivo(true);
                else cl.setActivo(false);
            }else{
                cl.setActivo(cl.getActivo());
            }
            ControladorCliente.almacenar(cl);

            System.out.println("\n\tModificado correctamente!. Pulse 'Intro' para continuar");
            Utils.pausa();
        }
    }


    /**
     * @throws ErrorBBDDException
     */
    private static void baja() throws ErrorBBDDException {
        System.out.println("\n\tModificaci�n de cliente\n");

        Cliente cl = seleccionPorUsuario();

        if (cl != null) {
            System.out.print("\n�Realmente desea eliminar el registro? (S/N): ");
            String str = Utils.getStringConsola();
            if (str.equalsIgnoreCase("S")) {
                try {
                    ControladorCliente.eliminar(cl);
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
    private static Cliente seleccionPorUsuario() throws ErrorBBDDException {
        Cliente cl = null;
        int id = -2;
        do {
            System.out.println("\n\tIntroduzca ID del cliente ('-1' - ver listado, '0' - salir): ");
            id = Utils.getIntConsola(1);
            if (id == -1) {
                listado(false);
            } else {
                if (id != 0) {
                    cl = ControladorCliente.get(id);
                    if (cl == null) {
                        System.out.println("\tError. Ha especificado un ID inv�lido.");
                    }
                }
            }
        } while (cl == null && id != 0);
        return cl;
    }
}
